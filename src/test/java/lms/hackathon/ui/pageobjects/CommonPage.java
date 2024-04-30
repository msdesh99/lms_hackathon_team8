package lms.hackathon.ui.pageobjects;

	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.google.common.collect.Ordering;

	public class CommonPage {

		WebDriver driver;
		By locator;
		List<String> columnContentList ; 
		List<String> beforeSortingList = new ArrayList<String>();
		List<String> afterSortingList = new ArrayList<String>();
		int lastPage=0;

	            public CommonPage(WebDriver driver) {
	            	super();
	            	this.driver = driver;
	            	PageFactory.initElements(driver,this);
	            }
		
	// @FindBy(xpath="//table[@role='grid']//th[contains(@class,'sortable')]")
	 //List<WebElement> sortableList;
	 
	 private By rows = By.xpath("//table[@role='grid']//tbody//tr");
     
	 private By nextButton = By.xpath("//div[contains(@class,'paginator')]//button[contains(@class,'paginator-next')]");
	 private By pages = By.xpath("//div[contains(@class,'paginator')]//span//button[contains(@class,'paginator')]");
	
	public void sortByField(String fieldName, int column) throws InterruptedException {	
			driver.findElement(By.id("user")).click();
			driver.findElement(By.xpath("//table[@role='grid']//th[(contains(@class,'sortable') "
					+ "and contains(text(),'"+fieldName+"'))]")).click();
		// beforeSorting();
		 afterSorting(column);
	 }	 
		 
	 public void afterSorting(int column) throws InterruptedException {
		 
			 columnContentList =  new ArrayList<String>(); 
			   List<WebElement> pageList = driver.findElements(pages);
			   int currentPg=0;
			   Boolean allPages = true; 
		while(allPages) {	   
			for(int pageNo=0;pageNo<pageList.size();pageNo++) { 		
			 if(currentPg<pageList.size()) {
				  if(driver.findElement(nextButton).isEnabled()) {
					   driver.findElement(nextButton).click();
					   checkContent(column);
				   }
				  else {
				  allPages=false;
				  break;
				  }
					   currentPg = pageNo;
			 }
		}
			   pageList = driver.findElements(pages);
			   if(pageList.size()==0){
				   allPages=false;
			   }
		}
		    afterSortingList = columnContentList;
	        displayList(afterSortingList);
		}
    
	 
	public void displayList(List<String> displayList) {
		int no=0;
	    for(String colText: displayList) {
	   	      no++;
				 System.out.println(no +" Text: "+colText);
			 }
	         System.out.println("Assertions: Is in Order: "+ Ordering.natural().isOrdered(displayList));
			 System.out.println("====End====");	
	}
		
	 public List<String> checkContent(int colNumber) throws InterruptedException {
		 int rowNumber;
		 colNumber= colNumber+1;
		 WebElement columnElement;
		 List<WebElement> rowList = driver.findElements(rows);
		   for(int row=0; row<rowList.size();row++) {
			 rowNumber = row+1;	
			 columnElement = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr["+rowNumber+"]//td["+colNumber+"]"));
			 columnContentList.add(columnElement.getText());
		 }
	    return columnContentList;
	 }
	 
}
