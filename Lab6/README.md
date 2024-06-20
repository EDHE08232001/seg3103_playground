# seg3103_playground
## Lab 06



### Part 1: Prerequisites
![image](https://user-images.githubusercontent.com/55165117/125734370-69770d9b-9424-4e7e-babf-1dd5ffd076ef.png)


### Part 2: Initial Compilations and Testing
![image](https://user-images.githubusercontent.com/55165117/125734546-a73c33cd-05ba-435f-80c6-b3a660d193f6.png)


run `mvn package -DskipTests`
![image](https://user-images.githubusercontent.com/55165117/125735091-ec5938ce-c9af-4a03-958b-227098ae42d8.png)
![image](https://user-images.githubusercontent.com/55165117/125739336-f3cad89b-7a62-4bf4-8d2f-2db7422ebd16.png)


ran `java -jar ./target/BookstoreApp-0.1.0.jar`.
![image](https://user-images.githubusercontent.com/55165117/125735166-bb73a9c5-da9b-4038-b401-fbe2a231fd21.png)


Application
![image](https://user-images.githubusercontent.com/55165117/125735271-21c8e8b0-8eaa-4cb4-9819-3c9ac1f37eeb.png)

`mvn test`
![image](https://user-images.githubusercontent.com/55165117/125735865-5189c41d-5625-47c2-a2ce-df2da22944f9.png)

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



