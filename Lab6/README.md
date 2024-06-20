# seg3103_playground
## Lab 06

Outline | Value
--------|-------
Course | SEG3103
Date | July 15, 2021
Professor | Andrew Forward aforward@uottawa.ca
TA | Zahra Kakavand, zkaka044@uottawa.ca
Team | Jasmine Kokkat 300115249


### Part 1: Prerequisites
Before I started the lab, I installed Maven successfully as shown in the image below when using the command `mvn --version`. 
![image](https://user-images.githubusercontent.com/55165117/125734370-69770d9b-9424-4e7e-babf-1dd5ffd076ef.png)


### Part 2: Initial Compilations and Testing
After extracting the zip file for BookstoreApp, I ran `mvn compile` as shown in the image below. 
![image](https://user-images.githubusercontent.com/55165117/125734546-a73c33cd-05ba-435f-80c6-b3a660d193f6.png)


I then ran `mvn package -DskipTests` which compiled all the tests without running them as shown in the following image. 
![image](https://user-images.githubusercontent.com/55165117/125735091-ec5938ce-c9af-4a03-958b-227098ae42d8.png)
![image](https://user-images.githubusercontent.com/55165117/125739336-f3cad89b-7a62-4bf4-8d2f-2db7422ebd16.png)


Next, I ran `java -jar ./target/BookstoreApp-0.1.0.jar`.
The terminal when running this command is shown below.
![image](https://user-images.githubusercontent.com/55165117/125735166-bb73a9c5-da9b-4038-b401-fbe2a231fd21.png)


The application running is shown in the following image.
![image](https://user-images.githubusercontent.com/55165117/125735271-21c8e8b0-8eaa-4cb4-9819-3c9ac1f37eeb.png)

I ran the initial three tests as seen in the following screenshot here using the command `mvn test`.
![image](https://user-images.githubusercontent.com/55165117/125735865-5189c41d-5625-47c2-a2ce-df2da22944f9.png)

### Part 3: Additional Testing

For this section, I implemented an additional Selenium web driver test for the login process. I added code to check that the username "admin" and the password "password" would direct the user to the admin page of the application when they click the "Sign in" button.
This is the snippet of code I added:
```
@Test
  public void test3() {
    driver.get("http://localhost:8080/admin");

    WebElement userID = driver.findElement(By.id("loginId"));
    userID.sendKeys("admin");
    WebElement loginPassword = driver.findElement(By.id("loginPasswd"));
    loginPassword.sendKeys("password");
    WebElement logIn = driver.findElement(By.id("loginBtn"));
    logIn.click();

    String actualUrl="http://localhost:8080/admin";
    String expectedUrl= driver.getCurrentUrl();
    assertEquals(expectedUrl, actualUrl);

  }
```
These are the passing results when running the four tests:
![image](https://user-images.githubusercontent.com/55165117/125736910-36c93f9a-9f84-4559-8c90-785f359327c3.png)



