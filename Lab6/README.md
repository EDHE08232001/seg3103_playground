# seg3103_playground
## Lab 06



### Part 1: Setup
![image](./assets/setup.png)


### Part 2: Run Application

run `mvn package -DskipTests` and `java -jar ./target/BookstoreApp-0.1.0.jar`.
![image](./assets/run.png)


Application
![image](./assets/application.png)

`mvn test`
![image](./assets/test.png)

### Part 3: Additional Testing

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

Result
![image](https://user-images.githubusercontent.com/55165117/125736910-36c93f9a-9f84-4559-8c90-785f359327c3.png)



