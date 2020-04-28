package record.learn.design.adtpter.pro;

public class Main {

	public static void main(String[] args) {
		FileIO fileIO = new FileProperties();
		try {
			fileIO.readFromFile("c:/test.properties");
			fileIO.setVal("year", "2012");
			fileIO.setVal("month", "10");
			fileIO.setVal("day", "17");
			fileIO.writrToFile("c:/testNew.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
