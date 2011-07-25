package pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * @author vera
 *
 * 21.11.2010 20:23:04
 */
public class AttachLogo
{
	private String sourcePdf;
	private String targetPdf;
	private String imageToAdd;

	public AttachLogo(String sourcePdf, String targetPdf, String imageToAdd)
	{
		this.sourcePdf = sourcePdf;
		this.targetPdf = targetPdf;
		this.imageToAdd = imageToAdd;
	}

	public void start() throws Exception
	{
		FileOutputStream outputStream = new FileOutputStream(new File(targetPdf));
		PdfReader reader = new PdfReader(new FileInputStream(new File(sourcePdf)));
		PdfStamper stamper = new PdfStamper(reader, outputStream);
		//stamper.set
		PdfContentByte overContent = stamper.getOverContent(1);

		//java.awt.Image awtImg = java.awt.Toolkit.getDefaultToolkit().createImage(imageToAdd);
		InputStream resourceAsStream = this.getClass().getResourceAsStream(imageToAdd);
		BufferedImage imageBuf = ImageIO.read(resourceAsStream);
		com.lowagie.text.Image image = com.lowagie.text.Image.getInstance(imageBuf, null);
		//image.setAbsolutePosition(50,750);
		//overContent.addImage(image);
		//overContent.addImage(image, 280, 0, 0, 30, 50, 750);
		//overContent.addImage(image, 532, 0, 0, 55, 50, 750);
		overContent.addImage(image, 266, 0, 0, 28, 50, 750);
		stamper.setFormFlattening(true);
		stamper.close();
		reader.close();
	}
}
