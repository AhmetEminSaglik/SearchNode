# <i>SearchNode </i>

## Content

<ol>
        <a href="#about-project"><li>About The Project</li></a>
        <a href="#why-project-created"><li>Why The Project Is Created?</li></a>
        <a href="#used-technologies"><li>Used Technologies</li></a>
        <a href="#image"><li>Images </li></a>
        </li>
        <a href="#requirements"><li>Requirements</li></a>
         </li>
        <a href="#installation"><li>Installation (Run In IntelliJ IDEA)</li></a>
        <a href="#searchnode-features" ><li> <span style="font-weight:bold;color:red;">SearchNode Library Features</span> </li></a>

<!--         <a href="#version-difference"><li>Version Difference</li></a> -->

</ol>

## <span id="about-project">1-) About The Project</span>

***SearchNode*** is a data structure library in Java programing language. It is similar to Trie data structure.
Besides an ordinary data structure it has more details on nodes. It stores unique data. But this feature is a little bit
different then HashMap.
One other important feature is about sorting. Usually sorting processes depend on speaking languages' alphabets. This
problem is fixed with
*SearchNode* library. Anything can be sorted as any requested order. Char/Chars should be updated as requested
order to use this feature by using `updatePriorityChar()` function. Much more detailed can be found in
<a href="#searchnode-features" ><span style="font-weight:bold;color:red">SearchNode Library Features</span>. </a>

## <span id="why-project-created">2-) Why The Project Is Created?</span >

There were two main purposes. One of them was to create faster searching algorithm than (Arraylist + Merge Sort + Binary
search) combination.
And second was to sort data as requested order. Not being addicted to any speaking language.
SearchNode data structure was planed to be get used in the future instead of ArrayList but so far both speed and memory
performances are not enough to use.

Kind of mixed ***Trie, Arraylist, and Hashset data structures***.

- Add data and search without using extra custom sort algorithm.
- Get all data sorted in list.
- Update chars' location as requested order.
- Decrease code complexity by removing sorting algorithm codes.
- Get unique data. Also get how many times the same value was added.

(Next version is designed to success or at least getting close to the main purpose but not having time to do it.)

## <span id="used-technologies">3-) Used Technologies</span>

* Core Technologies:
  * JAVA SE
* Dependencies:
  * org.junit.jupiter.junit-jupiter:RELEASE

## <span id="image">4-) Images </span>

### 1. Add data to SearchNode data structure.

!["images/1.png"](images/1.png) <br><br>

### 2. Search "AES" data from SearchNode data structure.

!["images/2.png"](images/2.png) <br><br>

### 4.  PriorityChar - Update Single Char : Sorts as requested order.

!["images/3.png"](images/3.png) <br><br>

### 4.  PriorityChar - Update Char List : Sorts as requested order.

!["images/4.png"](images/3.png) <br><br>


### 5.  PriorityChar - Update Char List : Sorts as requested order.

!["images/5.png"](images/5.png) <br><br>

## <span id="requirements">5-) Requirements</span>

* <a href="https://www.oracle.com/tr/java/technologies/javase/jdk11-archive-downloads.html">JDK 11</a>
* <a href="https://www.jetbrains.com/idea/download/?section=windows"> IntelliJ IDEA (Community Edition) </a>


## <span id="installation">6-) Installation (Run In IntelliJ IDEA)</span>

**1.** Copy and paste the following command in your cmd.

```
git clone https://github.com/AhmetEminSaglik/SearchNode.git
```

**2.**  You can select how to import following one of the instructors bellowed.
  * First option: Adding Jar file as library:
    1. Add `searchnode-1.0.jar` to your project as Jar file in `SearchNode` folder.
  
  * Second option: Add Jar file as Maven dependency:
    1. Copy `org` folder in `maven-setup` to your `.m2\repository`
    2. Add following dependency to your project's pom.xml
```xml
<dependency>
    <groupId>org.ahmeteminsaglik</groupId>
    <artifactId>searchnode</artifactId>
    <version>1.0</version>
</dependency>
```

## <span id="searchnode-features"> 7-)<span style="color:red"> SearchNode Library Features</span>

### NOTE : SearchNode data structure was designed generic. But for now working correctly only for String values.   

### Concepts
#### <span style="color:cyan"> Priority Char </span>: 

- Is used to change chars standard order. if is not used any priority char then sorts to ASCII order.
If any priority char is used then new double value is assigned to char. And that value is used at sorts. 

### 1. Initializing SearchNode 
```java
//for beginner users to SearchNode data structure.
SearchNodeService<String> searchNode = new SearchNode<>();

// for advanced users to SearchNode data structore
SearchNode<String> searchNode = new SearchNode<>();
```
### 2. Adding Data

```java
// 1-) Add only data.
searchNode.add("Code");

// 2-) Add only data list.
List<String> dataList = new ArrayList<>();
... // fill dataList.
searchNode.addAll(dataList);

// 3-) First parameter is data. Second parameter is explanation.
searchNode.add("Code","Code First Explanation");

// 4-) First parameter is data. Second parameter is explanation list.
List<String> explanationList = new ArrayList<>();
... // fill explanationList.
searchNode.add("Code", explanationList);
```

### 3. Read Data

```java
// A-)  Search Data
    // 1-) get NodeDataService
NodeDataService<String> nds= searchNode.search("AES");
        
        // returns node's depth value.
        nds.getDeep();
        
        // returns node's location address
        nds.getLocationAddress(); 
        
        // return next directions total data value
        nds.getNextDirectionsTotalValueNumber(); 

    // 2-) get DataInfo value. This list size change according to different explanation values.
DataInfo<String> dataInfo=nds.getListDataInfo().get(0);

       // returns added data index no for located Node.        
       dataInfo.getIndex(); 

       // returns added data        
       dataInfo.getValue(); 

       // returns added explanation        
       dataInfo.getExplanation();  

       // returns added total same data and explanation value.        
       dataInfo.getTotalSameNum(); 
```

```java
// returns all data in requested order.
searchNode.getAll();

// return all data in reversed order.
searchNode.getAllReverse();

// return all PriorityChar list.
searchNode.getAllPc();

// returns all starting data with "AES".
searchNode.getAllStartWith("AES");

// returns next char of 'c'. This is completely changeable to PriorityChar.
searchNode.getNextPc('c');

// returns total size of added data.
searchNode.getTotalItemNumber(); 
```

### 4. Update Data

```java
// first parameter is data, second parameter is old explanation, third parameter is new explanation
searchNode.update("data","old explanation", "new explanation");

// first parameter is data, second parameter is new explanation List. If empty explanation is found, updates it. Otherwise create same data new explanations.
List<String> explanationlist= new ArrayList<>();
... // add explanationList
searchNode.update("data", explanationList);

// first parameter is data, second parameter is old explanation, third parameter is new explanation List.
List<String> explanationlist= new ArrayList<>();
... // add explanationList
searchNode.update("data","old explanation", explanationList);

//first parameter is the char that will be updated next to second parameter char.
searchNode.updatePriorityChar('b','y'); // order : a,c....y,b,z

//first parameter is the char list that will be updated next to second parameter char.
List<Character> charList= new ArrayList<>();
... // fill charList.
//lets say charList is d,b,c
searchNode.updatePriorityChar(charList,'y'); // then order will be : a,e,...y,d,b,c,z
```

### 5. Delete Data

```java
// delete priorityChar value for given char. Which means ASCII code's value will be used for this char.
searchNode.resetPriorityChar('c');

// deletes all priorityChar. Which means ASCII codes' values will be used for whole chars.
searchNode.resetAllPriorityChars(); // 

// delete AES data. And deletes all explanation in it.
searchNode.remove("AES");

//deletes given list data
List<String> dataList = new Arraylist<>();
...// add data to list;
searchNode.removeAll(dataList); 
```

