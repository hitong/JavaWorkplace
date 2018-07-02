package version2;

import java.io.File;
import java.io.IOException;

public interface GeometricObject{
	double PI = 3.14;
	String draw();
	GeometricObject[] erase(GeometricObject[] geometricObject);
	String getArea();
	String getPerimeter();
	void writeToFile(File file) throws IOException;
}
