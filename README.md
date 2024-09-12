# <i>SearchNode </i>

??? GIF EKLENEBILIR
<br> <br>

## Content

<ol>
        <a href="#about-project"><li>About The Project</li></a>
        <a href="#why-project-created"><li>Why The Project Is Created?</li></a>
        <a href="#used-technologies"><li>Used Technologies</li></a>
        <a href="#image"><li>Images </li></a>
                <ol> 
                        <a href="#windows-cmd-output"><li>Windows CMD Output</li></a>
                        <a href="#intelij-idea-output"><li> Intellij IDEA Output</li></a>
                </ol>
        </li>
        <a href="#requirements"><li>Requirements</li></a>
         <a href="#quick-start"><li>Quick Start</li></a>
         <ol>
	<a href="#run-in-cmd"><li>Run in CMD</li></a>
        <!-- <a href="#run-in-docker"><li>Run in Docker</li></a>-->
         </ol>
         </li>
        <a href="#installation"><li>Installation (Run In IntelliJ IDEA)</li></a>
        <a href="#searchnode-features" ><li> <span style="font-weight:bold;color:red;">SearchNode Library Features</span> </li></a>

<!--         <a href="#version-difference"><li>Version Difference</li></a> -->

</ol>



## <span id="about-project">1-) About The Project</span>

***SearchNode*** is a data structure library in Java programing language. It is similar to Trie data structure.
Besides an ordinary data structure it has more details on nodes. It stores unique data. But this feature is a little bit different then HashMap.
One other important feature is about sorting. Usually sorting processes depend on speaking languages' alphabets. This problem is fixed with
*SearchNode* library. Anything can be sorted as any requested order. Only thing to use this feature, char/chars should be updated as requested
order using `updatePriorityChar()` function. Much more detailed can be found in <a href="#searchnode-features" ><span style="font-weight:bold;color:red">SearchNode Library Features</span>. </a>

## <span id="why-project-created">2-) Why The Project Is Created?</span >

During interviews, I was asked a few times about my experience with JPA and Hibernate tools. While I mentioned that I
use JPA within Spring Boot, some interviewers preferred not to consider that experience, as JPA is integrated into
Spring Boot. To address this, I decided to create a project that allows for easy switching between JPA and Hibernate,
enabling a clear demonstration of both frameworks in action. This project serves as a practical example of JPA and
Hibernate implementations.

## <span id="used-technologies">3-) Used Technologies</span>

* Core Technologies:
    * JAVA SE
    * Log4j
    * MySQL
* Dependencies:
    * org.hibernate.hibernate-core:6.2.8.Final
    * log4j.log4j:1.2.17
    * mysql.mysql-connector-java:8.0.31
    * org.junit.jupiter.junit-jupiter:RELEASE
    * javazoom.jlayer:1.0.1
        * To play music background while running the program.
    * com.ahmeteminsaglik:console-colorful-text:1.1
        * To print colorful both Cmd and Intellij Idea.

## <span id="image">4-) Images </span>

[//]: # (### <span id="windows-cmd-output"><li> Windows CMD Output </li> </span>)
<details>
<summary> <span id="windows-cmd-output" style="font-size: 20px;"> Windows CMD Output  </span></summary>

### 1. Activating CMD Printing Tool.

!["images/cmd/1.png"](images/cmd/1.png) <br><br>

### 2. Activating ORM Logs

!["images/cmd/2.png"](images/cmd/2.png) <br><br>

### 3. Activating JPA

!["images/cmd/3.png"](images/cmd/3.png)<br><br>

### 4. Saving Address Data (ORM Logs from for JPA Implementation)

!["images/cmd/5.png"](images/cmd/5.png)<br> <br>

### 5. Find All Address Data (ORM Logs from for Hibernate Implementation)

!["images/cmd/7.png"](images/cmd/7.png)<br> <br>

### 1. Custom Terminal Commands - Help .

!["images/cmd/21.png"](images/cmd/21.png) <br><br>

### 2. Custom Terminal Commands - Inner process .

This may looks hard to understand but it is easy. Get relax.

1. Main process is about saving a new Student.
2. Instead of typing Student's grade, a new terminal commands is typed as `>> -r -A` which means `read Address`.
3. After completed 2. process, come back to 1. process. But again, terminal commans is typed. This time `>> -c -A` which
   means `create Addres`
4. After compoeted 3. process, come back to 1. process again. And this time just goes on 1. process.

!["images/cmd/21.png"](images/cmd/22.png) <br><br>

### 8. Find All Student Data

!["images/cmd/11.png"](images/cmd/11.png)<br> <br>

### 10. Saving New Course - Other Course

!["images/cmd/13.png"](images/cmd/13.png)<br> <br>

### 12. Student Save process invalid input and try to save without address data.

!["images/cmd/15.png"](images/cmd/15.png)<br> <br>

### 17. Save Exam Result - Course step and score.

!["images/cmd/20.png"](images/cmd/20.png)<br> <br>

</details>

<br>

<details>
<summary> <span id="intelij-idea-output" style="font-size: 20px;"> IntelliJ IDEA Output  </span></summary>

### 1. Activating IDEA Printing Tool.

!["images/idea/1.png"](images/idea/1.png) <br><br>

### 2. Retrieve all Exam Result data.

!["images/idea/3.png"](images/idea/3.png) <br><br>

### 3. Retrieve all Exam Result data by invalid Course Name.

!["images/idea/4.png"](images/idea/4.png) <br><br>

### 4. Retrieve all Exam Result data by Course Name.

!["images/idea/6.png"](images/idea/6.png) <br><br>

</details>

## <span id="requirements">5-) Requirements</span>

* <a href="https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html">JDK 11</a>
* <a href="https://www.jetbrains.com/idea/download/?section=windows"> IntelliJ IDEA (Community Edition) </a>
* MySQL
    * Username: `root`
    * Password: ` `
    * port:: `3306`

## <span id="quick-start">6-) Quick Start </span>

### <span id="run-in-cmd"> Run In Windows CMD </span>

**1.** First of all, the project requires a running MySQL server. If you have not yet installed a MySQL server but
docker desktop, then you can copy and paste the following command to your CMD to create a proper MySQL container to run
the project.  
Default login credentials must be the same as given in  <a href="#requirements">requirements</a> part.   
(If you want to change login credentials please go to <a href="#installation"> installation </a> part.)

```dockerfile
docker run --name jpa-hibernate-mysql -p 3306:3306  -e MYSQL_ALLOW_EMPTY_PASSWORD=1 -d mysql
```

To test whether the MySQL container is running properly, you can copy and paste the following command.

```
docker ps
```
If you see running a docker container named `jpa-hibernate-mysql` then it means you successfully launched the MySQL.


**2.** Copy and paste the following command in your cmd.
<br>

```
git clone https://github.com/AhmetEminSaglik/JPA-vs-Hibernate.git
```

**3.** Copy and paste the following command into your cmd.

```
java -jar  JPA-vs-Hibernate/Jpa-vs-Hibernate.jar
```

## <span id="installation">7-) Installation (Run In IntelliJ IDEA)</span>

**1.** Copy and paste the following command in your cmd.

```
git clone https://github.com/AhmetEminSaglik/JPA-vs-Hibernate.git
```

**2.** To run this project one dependency must be added to the project. You can go to following link to figure out how
to install it directly to the project.

* <a href="https://github.com/AhmetEminSaglik/Console-Colorful-text?tab=readme-ov-file#installation"> Colorful Print Tool Module </a>

[//]: # (* <a href="https://github.com/AhmetEminSaglik/MusicPlayerForConsoleApp?tab=readme-ov-file#installation"> Music Player Console Module </a>)

**3.** If you want to change mysql connect data then update both JPA and Hibernate configuration files.

* JPA configuration file :
    * src/main/resources/META-INF/`persistence.xml`   
      (update both `persistenceUnitRealProject` and `persistenceUnitTest`)

```xml

<property name="jakarta.persistence.jdbc.url"
          value="jdbc:mysql://localhost:YOUR_PORT/school_db_test?createDatabaseIfNotExist=true"/>
<property name="jakarta.persistence.jdbc.user" value="YOUR_USERNAME"/>
<property name="jakarta.persistence.jdbc.password" value="YOUR_PASSWORD"/>
```

* Hibernate configuration file :
    * src/main/resources/hibernate.cfg.xml/`hibernate.cfg.xml`
    * src/main/resources/hibernate.cfg.xml/`hibernate_test.cfg.xml`

```xml

<property name="connection.url">jdbc:mysql://localhost:YOUR_PORT/school_db?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;createDatabaseIfNotExist=true</property>
<property name="connection.username">YOUR_USERNAME</property>
<property name="connection.password">YOUR_PASSWORD</property>
```

## <span id="searchnode-features"> 8-)<span style="color:red"> SearchNode Library Features</span>

This feature is added to make this project extraordinary, making not an ordinary project.  
**NOTE:** `>>` is default prefix to run in Custom Terminal. It can be switch in program. After launch the program, `Main > setting > Update Terminal Prefix`.  
**NOTE:** To use Custom terminal feature, prefix must be added.   
Example :  `>> -h`, `>> -r -S`, `>> -q`,`>> -e`

* Core commands must be use alone (`>>-q`).
* Standard Commands must be use together (`>>-r -S`).
    * Lower cases present CRUD operation (`-r`).
    * Upper cases present Object (`-S`).

### 1. Terminal - Core Commands

| Example Using | Meaning                | 
|:-------------:|:-----------------------|
|      -q       | Cancel Current Process |
|      -e       | Exit Program           |
|      -h       | Help                   |


### 2. Terminal -  Standart Commands (Process Data Commands)

| Shortcut  Command | Long  Command | Shortcut  Object | Normal Object |
|:-----------------:|:--------------|------------------|:--------------|
|        -c         | create        | -A               | Address       |
|        -r         | read          | -S               | Student       |
|        -u         | update        | -C               | Course        |
|        -d         | delete        | -ER              | ExamResult    |

### 3.Terminal Commands - One Command ~ Multi Syntax

| Example Using (Shortcut-Commands) | Example Using (Standard-Commands) | Meaning              | 
|:---------------------------------:|:----------------------------------|:---------------------|
|               -c -A               | create Address                    | Creates Address      |
|               -A -c               | create Address                    | Creates Address      |
|          create Address           | create Address                    | Creates Address      |
|          Address create           | create Address                    | Creates Address      |


### 3.Terminal Commands - Example Usage

| Example Using (Shortcut-Commands) | Example Using (long-Commands) | Meaning                                   | 
|:---------------------------------:|:------------------------------|:------------------------------------------|
|                -h                 | help                          | Prints how to use Custom Terminal feature |
|                -q                 | quit                          | Cancel current Process                    |
|               -r -S               | read Student                  | Read Student                              |
|               -u -C               | update Course                 | Updates Course                            |
|              -d -ER               | delete ExamResult             | Deletes  Exam Result                      |

