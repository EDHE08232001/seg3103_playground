# LAB 7

### SETUP

Running

`javac -encoding UTF-8 --source-path src -d dist src/*.java.`

`javac -encoding UTF-8 --source-path test -d dist -cp dist:lib/junit-platform-console-standalone-1.7.1.jar test/*.java`

Then run

`java -cp ./dist Main` and `java -jar ./lib/spotbugs/lib/spotbugs.jar` for SpotBugs.


The images of running application:

![image](./assets/RunningApplication.png)

Creating a new project:
![image](./assets/TestSetup.png)


The screenshot below shows SpotBugs with a total of 18 bugs:

![image](./assets/Errors.png)


### Bug 1: Comparison of String parameter using == or !=

![image](./assets/Bug1.png)

Fix:

![image](./assets/Fix1.png)


### Bug 2: Certain swing methods needs to be invoked in Swing thread

![image](./assets/Bug2.png)

Fix:

![image](./assets/Fix2.png)

In the main method, the isVisible() Swing method is being called which could cause deadlocks or other threading issues since Java Swing components are not thread-safe in Java. The SwingUtilities.invokeLater() method delays the GUI creation task until the initial thread's tasks have been completed and will then ensure the GUI creation takes place inside the method for the thread.


### Bug 3: Could be refactored into a named static inner class

![image](./assets/Bug3.png)

To fix the code, I would create a WindowAdapter class within the CalCFrame class and in the CalCFrame method would call WindowAdapter.WindowClosing(WindowEvent e), passing in a WindowEvent as as argument, instead of creating a new WindowAdapter.

### Bug 4: Private method is never called

![image](./assets/Bug4.png)

Fix:

![image](./assets/Fix4.png)

### Bugs 5 and 6: Boxing/unboxing to parse a primitive

![image](./assets/Bug5.png)

Fix:

![image](./assets/fix5a.png)

![image](./assets/fix5b.png)

### Bugs 7-12: Unread field: should this field be static?:
![image](./assets/Bug7to12.png)

Fix:

![image](./assets/fix7to12.png)

### Bug 13: Method uses the same code for two branches:

![image](./assets/Bug13.png)

Fix:

![image](./assets/fix13.png)


### Bug 14: Switch statement found where default case is missing
![image](./assets/Bug14.png)

Fix:

![image](./assets/fix14.png)

### Bugs 15-18: Condition has no effect
Below are screenshots of the bug before making the changes:
![image](./assets/Bug15to18a.png)

![image](./assets/Bug15to18b.png)

These are screenshots of the fixed bugs.

![image](./assets/fix15to18a.png)

![image](./assets/Bug15to18b.png)

After fixing 17 bugs, the screenshot below shows the updated SpotBug errors:
![image](./assets/Bug17.png)
