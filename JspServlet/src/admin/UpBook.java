package admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import  org.apache.commons.fileupload.servlet.ServletFileUpload;

import been.Book;
import dao.Dao;

@SuppressWarnings("serial")
public class UpBook extends HttpServlet {
	PrintWriter out=null;
	/**
	 * 处理请求 
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置中文 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		out= response.getWriter();	
		Book book = new Book();
		//确定本次请求是否是文件上传请求
		boolean flag=ServletFileUpload.isMultipartContent(request);
		if(flag){
			//创建文件上传的工厂对象
			FileItemFactory factory=new DiskFileItemFactory();
			//创建ServletFileUpload对象，并将工厂对象作为参数传入
			ServletFileUpload upload=new ServletFileUpload(factory);
			//设置上传文件的大小
			upload.setSizeMax(1024*1024*12); //12m
			//使用上传对象从请求对象中解析出提交的所有表单元素
			try {
				List<FileItem> lstForms=upload.parseRequest(request);
				//遍历所有表单元素
				int t = 0;
				String op = "";
				String url = "";
				for (FileItem fileItem : lstForms) {
					t++;
					//判断每一个表单元素是否是普通表单
					if(fileItem.isFormField()){
						if(t == 10){
							String tmp = fileItem.getString("UTF-8");
							op  = tmp.substring(0,6);
							url = tmp.substring(6);
						}
						else{		
							book.set(fileItem.getString("UTF-8"));
						}
					}
					else{
			
							//上传前准备工作
							//a、上传后的路径this.getServletContext().getRealPath("/")会出去当前项目在 部署的服务器上的绝对路径
							String path=this.getServletContext().getRealPath("/");
							//b、找出要上传的文件的名字
							fileItem.getContentType();
							Date d = new Date();
							String fileName= d.getTime() + ".";
							fileName = fileName + fileItem.getContentType().substring(fileItem.getContentType().indexOf('/') + 1);
							book.set(fileName);
							fileItem.write(new File(path+fileName));					
						
					}
				}
				if(op.compareTo("upBook") == 0){
					Dao.addBook(book);
				}
				else{	
					Dao.updateBook(book);
				}	
				response.sendRedirect(url);
			} catch (Exception e) {
				System.out.println("错误："+e.getMessage());
			}
		}else{
			System.out.println("没有上传");
		}
		out.flush();
		out.close();
	}
}
