import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.Arrays; 
import java.util.zip.ZipEntry; 
import java.util.zip.ZipInputStream; 
import java.util.zip.ZipOutputStream; 

class ZipOutputStreams
{ 
	public static void main(String[] args) throws IOException 
	{ 
		
		FileOutputStream fos = new FileOutputStream("CRM"); 
		ZipOutputStream zos = new ZipOutputStream(fos); 

		//illustrating setMethod() 
		zos.setMethod(8); 
		
		//illustrating setLevel method 
		zos.setLevel(5); 

		ZipEntry ze1 = new ZipEntry("ZipEntryFile"); 
		 
	
		//illustrating putNextEntry method 
		zos.putNextEntry(ze1); 

		for(int i = 0; i < 10; i++) 
			{
			zos.write(i+48);
			zos.write('\n');
			} 
	
		//illustrating write(byte b[], int off, int len) 
		byte b[] = { 11, 12}; 
		zos.write(b); 


		//illustrating closeEntry() 
		zos.closeEntry(); 
		
		//Finishes writing the contents of the ZIP output stream 
		// without closing the underlying stream 
		zos.finish(); 
		
		//closing the stream 
		zos.close(); 

		FileInputStream fin = new FileInputStream("CRM"); 
		ZipInputStream zin = new ZipInputStream(fin); 

		//Reads the next ZIP file entry 
		ZipEntry ze = zin.getNextEntry(); 

		//the name of the entry. 
		System.out.println(ze.getName()); 

		//illustrating getMethod 
		System.out.println(ze.getMethod()); 

		//Reads up to byte.length bytes of data from this input stream 
		// into an array of bytes. 
		byte c[] = new byte[12]; 
		
		if(zin.available() == 1) 
			zin.read(c); 

		System.out.print(Arrays.toString(c)); 
		
		//closes the current ZIP entry 
		zin.closeEntry(); 
		
		//closing the stream 
		zin.close(); 
	

	} 
} 
