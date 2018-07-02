package util;

public class SplitPage {
       //分页请求时,请求标识参数
       final public static String FIRSTPAGE="first";//请求第一页
       final public static String PREVIOUSEPAGE="previous";//请求上一页
       final public static String NEXTPAGE="next";//请求下一页
       final public static String LASTPAGE="last";//请求最后一页
      
       private int pageRows=10;
       private int totalRows=0;
       private int currentPage=1;
       private int firstPage=1;
       private int totalPages=1;
      
       public SplitPage(int pageRows){
    	  this.setPageRows(pageRows);
       }
       
       public SplitPage(){
        }
       
       public int getCurrentPage() {
              return currentPage;
       }
       
       public void setCurrentPage(int currentPage) {
              this.currentPage = currentPage;
       }
      
       public int getFirstPage() {
              return firstPage;
       }
       public void setFirstPage(int firstPage) {
              this.firstPage = firstPage;
       }
      
       public int getPageRows() {
              return pageRows;
       }
       public void setPageRows(int pageRows) {
              if(pageRows==0)throw new ArithmeticException();
              this.pageRows = pageRows;//如果pageRows被设置为零,应当抛出异常.
              //修改每页显示记录数,将会直接影响总页面数,所以要同时修改
              this.totalPages=(this.totalRows % this.pageRows==0) ? this.totalRows / this.pageRows:this.totalRows/this.pageRows+1;
       }
       public int getTotalRows() {
              return totalRows;
       }    
       //设置分页对象的总记录属性后,就应该根据每页面显示记录数,计算得到总的页面数
       public void setTotalRows(int totalRows) {
              this.totalRows = totalRows;
        //计算总的页面数(或最后的页面号),两个整数相除如果刚好除尽,值就是相除后的商,否则如果有余数,商应当还加1.
              this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1;
       }
       //不应该提供方法设置总页面数,它是计算得到的
       //但应当提供获取总页面数的方法.
       public int getTotalPages() {
              return totalPages;
       }
      
       //根据请求页面的标识参数,重新计算当前要显示的页面
       //核心方法,实现分页显示功能.
       public int confirmPage(String flag){
              int newPage=this.currentPage;
              if(flag!=null){//flag只可能是下面值之一
                     if(flag.equals(SplitPage.FIRSTPAGE)){
                            newPage=1;
                     }else if(flag.equals(SplitPage.LASTPAGE)){
                            newPage=this.totalPages;
                     }else if(flag.equals(SplitPage.NEXTPAGE)){
                            //页面总数和当前页面编号相等吗,如果是那么页面编号不往后走,否则页面编号加一
                            newPage=(this.totalPages==this.currentPage)?this.currentPage:this.currentPage+1;
                     }else if(flag.equals(SplitPage.PREVIOUSEPAGE)){
                            //第一个页面和当前页面相等吗,如果是那么页面编号不往前走,否则页面编号减一
                            newPage=(this.firstPage==this.currentPage)?this.currentPage:this.currentPage-1;
                     }else{//否则是一个数字字符串
                            int tpage=Integer.parseInt(flag.trim());
                            newPage=tpage;
                     }
              }else{//如果请求标识参数为空,那么当前页码不变
	                     newPage=this.currentPage;
	              }
	              //在返回前设置当前页面
	              this.setCurrentPage(newPage);
	              return newPage;
       }
}