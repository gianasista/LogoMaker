import pdf.AttachLogoUI;




public class LogoMaker
{
	public static void main(String[] args) throws Exception
	{
		/*
		FileOutputStream outputStream = new FileOutputStream(new File("/tmp/result.pdf"));
		PdfReader reader = new PdfReader(new FileInputStream(new File("Source.pdf")));
		PdfStamper stamper = new PdfStamper(reader, outputStream);
		PdfContentByte overContent = stamper.getOverContent(1);

		java.awt.Image awtImg = java.awt.Toolkit.getDefaultToolkit().createImage("EclipseCpp.jpg");
		com.lowagie.text.Image image = com.lowagie.text.Image.getInstance(awtImg, null);
		image.setAbsolutePosition(400,700);
		overContent.addImage(image);
		stamper.setFormFlattening(true);
		stamper.close();
		reader.close();
		*/
		AttachLogoUI attachLogoUI = new AttachLogoUI();
		attachLogoUI.create();
	}

}
