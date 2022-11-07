package org.aes.searchnode.fakedata;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringText {
    private List<Field> fieldList = new ArrayList();
    public List<String> textList = new ArrayList();

    public StringText() {

        fieldList.addAll(Arrays.asList(getClass().getDeclaredFields()));
        fieldList.remove(0);
        fieldList.remove(0);
        try {
            for (int i = 0; i < 1/*fieldList.size()*/; i++) {
                fieldList.get(i).trySetAccessible();
                textList.add((String) fieldList.get(i).get(this));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("textList : " + textList.size());


    }

    String text0 = "testing tost3 tost3 tost3 tost3 tos write";

    String text1 = "Apex Unit " +
            " testing framework write triggers onLightning Platform unit high quality for your let meet requirements deploying " +
            "Testing iskey successful long term development critical ofdevelopment framework makes easy code only written sandbox environment " +
            " Developer not production deployed production org from sandbox as can distribute ers their to by uploading packages Lightning Platform AppExchange addition being critical quality assurance unit are requirements deploying distributing " + "These arebenefits unit " + "Ensuring triggers work expected " +
            " Having a suite regression every triggers are updated future updates make don’t break existing functionality " +
            "Meetingcode requirements deploying production distributing via packages " +
            "High quality apps delivered toproduction makes production rs productive " +
            "High quality apps delivered package subscribers increase trust " +
            "Note " +
            "Before each major service upgrade Salesforce on behalf through of process called s incurrent version and next release comparestest " +
            "This s thatbehavior hasn’t altered found result service upgradesHammer picks results selectively doesn’t Issues are " +
            "triaged based on certain criteria Salesforce strives fix issues each release ";
    String text2 =
            "Maintainingsecurity our highest priority We dont view modify any data is done in copy that secure center " +
                    "Code Requirement Deployment " +
                    "Before deploy package forLightning Platform AppExchange at least must covered by those must pass addition each trigger must though" +
                    "code requirement deployment don’t write meet requirement Make sure testcommon cases including positive negative cases bulk single record processing " +
                    "Test Syntax " +
                    "Test methods are defined using annotation havefollowing syntax " +
                    " void testName " +
                    " code_block " +

                    " annotation takes multiple modifiers parentheses separated by blanks We’ll cover one such parameter later " +
                    " visibility doesn’t matter so declaring public private doesn’t make difference astesting framework always able access methods reasonaccess modifiers are " +
                    "omitted insyntax " +
                    "Test methods must defined are annotated sample shows definition one ";
    String text3 =
            " " +
                    "private MyTestClass " +
                    " void myTest " +
                    " code_block " +


                    "Test classes be either private or public If you’re using unit declare private Public are typically d factory are covered later " +
                    "Unit Example Temperature " +
                    " simple example three methodsclass that’s being tested takes Fahrenheit input converts Celsius returnsconverted result" +
                    " Let’s add its " +
                    "In File | | enter Temperature forclass name OK " +
                    "Replacedefault body withfollowing " +
                    "public Temperature " +
                    " Takes Fahrenheit returnsCelsius equivalent " +
                    " public FahrenheitToCelsius " +
                    " = Decimal " +
                    " setScale ";
    String text4 =
            "Press Ctrl+S save " +
                    "Repeatprevious steps Temperature Addfollowing " +
                    " " +
                    "private Temperature " +
                    " void testWarmTemp " +
                    " celsius = Temperature FahrenheitToCelsius " +
                    " void testFreezingPoint " +
                    "Decimal celsius = Temperature FahrenheitToCelsius " +
                    " void testBoilingPoint " +
                    " celsius = Temperature FahrenheitToCelsius " +
                    " void testNegativeTemp " +
                    " celsius = Temperature FahrenheitToCelsius ";
    String text5 =
            " Temperature test verifies thatmethod works expected by calling different fortemperature Fahrenheit Each verifies one type input warm temperature" +
                    "freezing temperatureboiling negative temperatureverifications are by callingSystem takes two parametersfirst isexpected value andsecond isactual value There another version takes third parameter—a string describescomparison being d testBoilingPoint optional string logged ifassertion fails " +
                    "Let’s methods " +
                    "In | " +
                    "Under Temperature " +
                    "To test methods Temperature totest Selected " +
                    " " +
                    "In seestatus ning Expandtest expand again until seelist individual were have green " +
                    " marks Inspect " +
                    "After automatically generated triggers code percentage in " +
                    " exampleclass you’ve tested Temperature has shown image " +
                    "View percentage " +
                    "Note " +
                    "Whenever modify refresh " +
                    "A known issue prevents updating correctly when ning subset update coverage use run rather " +
                    " than | " + "While one would resulted full Temperature it’s still important ensure the" +
                    " quality Obviously isn’t possible every but common points different ranges input example passing " +
                    "positive negative numbers boundary values parameter values negative behavior for Temperature Converter common points like the" +
                    " boiling negative temperatures " + " Temperature test doesn’t cover higher invalid inputs boundary conditions Boundary conditions are minimum " +
                    "and maximum values case temperature conversion accepts accept large numbers than Double values there " +
                    " butonly input How does conversion handle value when dereferencesparameter variable evaluate" +
                    "formula throws NullPointerException modifyFahrenheitToCelsius input verify" +
                    " input behavior " + "Up pass beca conversion formula d inclass correct But that’s boring Let’s try simulate failure just to" +
                    " see what happens when fails example let’s modifyboiling pass false expected value forboiling Celsius instead" +
                    " void testBoilingPoint " +
                    " This ca s corresponding method fail " + "Change test Boiling Point to following " +
                    " celsius = Temperature FahrenheitToCelsius " +
                    " Simulate failure " +
                    " celsius Boiling not expected ";
    String text6 =
            "To execute same clicklatest in | Re assertion test BoilingPoint fails throws fatal error AssertException can’t caught " +
                    " results in by tab expandinglatest test reports one four failed get details ab failure double clicktest Detailed " +
                    "appear separate shown image Inspect failed " +
                    "To geterror message fortest failure double insideErrors column forfailed You’ll seefollowing descriptive text next Failed istext we provided in" +
                    "System statement " + "System AssertException Failed Boiling not expected Expected Actual " +
                    " these methods are numbers not Salesforce records You’ll find how Salesforce records how set up innext unit " + "Increase " +
                    "Code " +
                    "When writing try achievehighest possible Don’t just aim islowest thatLightning Platform requires deployments packages " +
                    " cases cover likelihood robust Sometimes after write methods methods not at One " +
                    "common ca not covering values conditional execution example values tend ignored when has if statements ca different branches to" +
                    " executed based on whetherevaluated condition met methods these different values " + "This example includesclass getTaskPriority contains" +
                    " two if statementsmain task priority string value based ongiven lead statemethod validatesstate first returns ifstate If the" +
                    "state CAmethod returns High otherwise returns Normal any other state value " + "public TaskUtil " +
                    " public String getTaskPriority String leadState " +
                    " Validate input " +
                    " if String isBlank leadState || leadState length " +
                    " " +

                    " String taskPriority " +
                    " if leadState == " +
                    " taskPriority = High " +
                    " " +
                    " taskPriority = Normal " +

                    " taskPriority ";
    String text7 = "Note " +
            " equality operator == performs insensitive string comparisons so there convertstring lower first means in" +
            " satisfyequality condition withstring literal " + "This istest f etTaskPriority methodtest simply" +
            " calls getTaskPriority one state NY " + " " +
            "private TaskUtilTest " +
            " void testTaskPriority " +
            " String = TaskUtil getTaskPriority NY " +
            " Normal " +


            "Let’s TaskUtilTest forcorresponding TaskUtil covers After" +
            "test finishescode TaskUtil shown If open see six blue covered lines two red uncovered lines shown image " + "Lines covered forTaskUtil " +
            " reason why line wasn’t covered beca our didn’t contain pass state parameter Similarly line wasn’t covered beca " +
            " didn’t pass asstate Let’s two methods cover those scenariosfollowing showsfull after addingtestTaskHighPriority testTaskPriority methods If classcode TaskUtil now at " + " " +
            "private TaskUtilTest " +
            " void testTaskPriority " +
            " String = TaskUtil getTaskPriority NY " +
            " assertEquals assert Equals Normal ";
    String text8 = " void testTaskHighPriority " +
            " String = TaskUtil getTaskPriority " +
            " High " +

            " void testTaskPriority " +
            " String = TaskUtil getTaskPriority Montana " +
            " null " +


            " " +
            "A collection example every prepare deployment Salesforce releases version Set up define set regularly " + "You now two These two aren’t related but let’s pretend formoment are Assume there are s when want these two but don’t want contains both execute " + "In select | " +
            "Enter Temp TaskUtil name OK ";
    String text9 = "Select TaskUtilTest hold downCtrl key select Temperature " +
            "To addselected editing window two selected " +
            " Save " +
            "Select | " +
            "Select Temp TaskUtil move Temp TaskUtil toSelected column " +
            " " +
            "On monitorstatus ning Expandtest expand again until seelist individual were Like individual methods double names see detailed " +
            " " +
            "Salesforce records are created methods aren’t committed todatabase rolled back whentest finishes execution rollback behavior handy beca don’t clean up setup after executes " + "By default don’t access pre existing except access metadata s such as r Profile s Set up Creating makes robust prevents failures are ca d by missing changed directly by using you’ll find later " + "Note " +
            " though not best practice do so there are s when needs access pre existing access annotatetest SeeAllData=truetest examples unit don’t access therefore don’t SeeAllData parameter " +
            "You save up MB each annotated don’t count toward limit " +
            " though rolls back separate d s s fields unique constraints inserting duplicate s records error ";
    String text10 = "Test methods don’t send emails " +
            "Test methods can’t make call s external services mock call s " +
            "SOSL searches performed empty predictable setFixedSearchResults definerecords returned bysearch " +
            "Resources " +
            " Guide Best Practices " +
            " Guide What Are Unit " +
            " Guide Isolation anization Unit " +
            "Salesforce Help ing " +
            "Test Triggers " + "Learning ives " +
            "After completing unit youll able " +
            "Write trigger fires on single record operation " +
            "Execute methods " +
            "Test Triggers " +
            "Before deploying trigger write unit performactions firetrigger expected ";
    String text11 = "Let’s trigger we worked Triggers module If record has related opportunitiesAccountDeletion trigger preventsrecord’s deletion " + "Prerequisites " +
            "If haven’t yet addedAccountDeletiontrigger follow these steps " +
            "In Console File | | Trigger " +
            "Enter AccountDeletion fortrigger name select fors Submit " +
            "Replacedefault withfollowing " +
            "trigger AccountDeletion on delete " +
            " Preventdeletion accounts if related opportunities " +
            " [SELECT Id " +
            " WHERE Id SELECT AccountId Opportunity " +
            " Id Trigger old] " +
            " Trigger oldMap get Id addError " +
            " delete related opportunities ";
    String text12 = "If addedAccountDeletiontrigger previous unit but disabled so thatsystem could challenge re enable " +
            " Triggers " +
            "On Triggers page Edit next toAccountDeletion trigger " +
            "Select Active " +
            " Save " +
            "If contains triggers previous unit AddRelatedRecord Call Trigger HelloWorldTrigger disable example disableAddRelatedRecordtrigger " +
            " Triggers " +
            "On Triggers page Edit next toAddRelatedRecord trigger " +
            "Deselect Active " +
            " Save " +
            "To disableHelloWorldTrigger Call Trigger triggers repeatprevious steps " +
            "Add Unit " +
            "First let’s start by adding method verifies whattrigger designed dopositive preventing being deleted if has related opportunities " + "In File | | " +
            "Enter TestAccountDeletion forclass name OK " +
            "Replacedefault body withfollowing " +
            " ";
    String text13 = "private TestAccountDeletion " +
            " void TestDeleteAccountWithOneOpportunity " +
            " " +
            " an opportunity try delete " +
            " acct = Name=Test " +
            " insert acct " +
            " Opportunity opp = Opportunity Name=acct Name + Opportunity " +
            " StageName=Prospecting " +
            " CloseDate=System today addMonths " +
            " AccountId=acct Id " +
            " insert opp " +
            " Perform " +
            " startTest " +
            " DeleteResult = delete acct false " +
            " stopTest Verify " +
            " casedeletion stopped bytrigger " +
            " so we got back error " +
            " isSuccess " +
            " getErrors size " +
            " Cannot delete related opportunities " +
            " getErrors [0] getMessage ";
    String text14 =
            " test first sets up opportunity Next deletestest firesAccountDeletion triggertest verifies thattrigger preventeddeletion oftest by ingreturn value ofDatabase delete callreturn value DeleteResult contains information ab delete operationtest verifies thatdeletion was not successful verifieserror message obtained " +
                    "To | " +
                    "Under TestAccountDeletion " +
                    "To methods inTestAccountDeletion totest Selected " +
                    " Findtest in underlatest " +
                    " TestAccountDeletion contains one single record forpositive Always scenarios thattrigger works cases including deleting with opportunities bulk deletions " + "Test set up insidetest consuming methods If many methods put creation callutility multiple methodsnext unit shows how take advantage methods " + " " +
                    " containsTest startTest stopTest pair delimits block gets fresh set governor limits test s two statements beforetest performed governor limits isolate setup’s limit usage test’s isolatedata process’s limit usage enclosetest withinTest startTest stopTest block block when asynchronous information see Using Limits startTest stopTest " + "Note " +
                    "A known issue prevents updating correctly when ning subset update | than | " + "Resources " +
                    " Guide Understanding " +
                    " Guide Triggers " +
                    " " + "Learning ives " +
                    "After completing unit youll able " +
                    " create " +
                    " set up various cases " +
                    "Execute methods " +
                    " " +
                    " reusable methods " + "Prerequisites " +
                    "Completeprerequisites inprevious unit Triggers if haven’t so already " + "Add ";
    String text15 = "Let’s refactorprevious by replacing creation First createtest " + " TestDataFactory special type class—it public annotated accessed ning Test contain methods by methods perform ful tasks such setting up are excluded ’s limit " + "To addTestDataFactory " + "In File | | enter TestDataFactory forclass name OK " +
            "Replacedefault body withfollowing " +
            " " +
            "public TestDataFactory " +
            " public createAccountsWithOpps Integer num Integer numOppsPerAcct " +
            " = " +
            " Integer i=0 i num i++ " +
            " = Name=TestAccount + i " +
            " add " +

            " insert " +
            " Opportunity opps = Opportunity " +
            " Integer j=0 j num j++ " +
            " acct = [j] " +
            " each just inserted opportunities " +
            " Integer k=0 k numOppsPerAcct k++ " +
            " opps Opportunity Name=acct Name + Opportunity + k " +
            " StageName=Prospecting " +
            " CloseDate=System today addMonths " +
            " AccountId=acct Id " +


            " Insert opportunities accounts " +
            " insert opps " +
            " return " +


            "This utility contains one createAccountsWithOpps acceptsnumber accounts held innum parameter andnumber related opportunities each held innumOppsPerAcct parameterfirst loop inmethod createsspecified number accounts stores in variable Afterfirst loopinsert statement accounts inlist indatabase " + " second loop createsopportunities Beca each group opportunities are linked one account er loop iterates through accounts contains nested loop creates related opportunities forcurrent accountnext nested loop opportunities are added tosame usingadd Opportunities are linked their parent accounts usingAccountId fieldtotal number opportunities are created isproduct ofnumber opportunities withnumber accounts numOppsPerAcctnum Nextinsert statement efficiently sideloop opportunities incollection accounts one " + "Finally returns ofnew accounts " + "Note ";
    String text16 = "Even though doesn’t returnrelated opportunities get those records by writing SOQL query makes ofexisting relationship between Opportunity such asquery d intrigger Triggers " + "Call Methods Creation " +
            "Now you’ve addedtest modifytest take advantage InTestAccountDeletion replaceblock starts ends insert opp " + " " +
            " one one opportunity by calling " +
            " Account[] = TestDataFactory createAccountsWithOpps " +
            " array returned byTestDataFactory createAccountsWithOpps contains one s " + "Here’smodified shorter version " + " " +
            "private TestAccountDeletion " +
            " void TestDeleteAccountWithOneOpportunity " +
            " " +
            " one one opportunity by calling " +
            " Account[] = TestDataFactory createAccountsWithOpps " +
            " Perform " +
            " startTest " +
            " DeleteResult = delete [0] false " +
            " stopTest " +
            " thatdeletion stopped bytrigger " +
            " so we got back error " +
            " " +
            " getErrors " +
            " delete related opportunities ";
    String text17 = " getErrors [0] getMessage " +


            "Test Conditions " +
            "One not enough possible fortrigger We other conditions such when with opportunities deleted We ame scenarios bulk number records instead just single record Here updated version oftest containsthree additional methods Save updated version ofclass " + " " +
            "private TestAccountDeletion " +
            " void TestDeleteAccountWithOneOpportunity " +
            " " +
            " one one opportunity by calling " +
            " Account[] = TestDataFactory createAccountsWithOpps " +
            " Perform " +
            " startTest " +
            " DeleteResult = delete [0] false " +
            " stopTest " +
            " thatdeletion stopped bytrigger " +
            " so we got back error " +
            " " +
            " getErrors " +
            " delete related opportunities " +
            " getErrors [0] getMessage ";
    String text18 =
            " void TestDeleteAccountWithNoOpportunities " +
                    " " +
                    " one opportunities by calling " +
                    " Account[] = TestDataFactory createAccountsWithOpps " +
                    " Perform " +
                    " startTest " +
                    " DeleteResult = delete [0] false " +
                    " stopTest " +
                    " thatdeletion was successful " +
                    " " +

                    " void TestDeleteBulkAccountsWithOneOpportunity ";
    String text19 = " " +
            " accounts one opportunity each by calling " +
            " Account[] = TestDataFactory createAccountsWithOpps " +
            " Perform " +
            " startTest " +
            " DeleteResult[] = delete false " +
            " stopTest " +
            " each record " +
            " casedeletion stopped bytrigger " +
            " so we got back error " +
            " DeleteResult dr " +
            " dr " +
            " dr getErrors " +
            " delete related opportunities " +
            " dr getErrors [0] getMessage ";
    String text20 = " void TestDeleteBulkAccountsWithNoOpportunities " +
            " " +
            " accounts opportunities by calling " +
            " Account[] = TestDataFactory createAccountsWithOpps " +
            " Perform " +
            " startTest " +
            " DeleteResult[] = delete false " +
            " stopTest " +
            " each record thatdeletion was successful " +
            " DeleteResult dr " +
            " dr " +


            " Methods ";
    String text21 = " final step test methods our now thatclass contains comprehensive has refactored factory Since you’ve already " +
            " inTestAccountDeletion just its methods " + "To executesame click select | " +
            " results in by expandinglatest test report four passed " +
            "Resources " +
            " Guide Common Creation" +
            "Get Started " + "Learning ives " +
            "After completing unit youll able " +
            "Describekey features " +
            "Save methods Anonymous " +
            " inspect debug logs " +
            "Before Begin " +
            "Were excited accompany on adventure While module covers basic information enables ab also it language goes deep If module first exposure we highly recommend first go throughQuick Start project come on back well waiting you " + "What " +
            " s Java like syntax acts like stored procedures business logic events such button clicks updates related records Visualforce pages " +
            "As " + "Hosted— saved compiled executed onserver— Lightning Platform " +
            " oriented— supports interfaces inheritance " +
            "Strongly typed— validates references s at compile " +
            "Multitenant aware—Beca multitenant platform guards closely against away by enforcing limits prevent monopolizing shared resources ";

    String text22 = "In addition insensitive " + "Development Tools " + "You write debug on client computer usingSalesforce Extensions Visual Studio See Salesforce Visual Studio Extensions " + "You write access debugging information directly inbrowser by usingSalesforce r interface Open under Name orquick access menu gear icon " + "Data Types Overview " +
            " supports various types including type specific Salesforce— s type " +
            " supportsfollowing types " + "A primitive such Integer Double Long Date Datetime String ID Boolean among others " +
            "An s generic s specific s such Contact My __c you’ll learn s s later unit " +
            "A collection including " +
            "A array primitives s s r defined s s created collections " +
            "A set primitives s s r defined s s created collections " +
            "A map primitive primitive s collection " +
            "A typed values known enum " +
            " r defined " +
            "System supplied " +
            " Collections " +
            "Lists hold ordered collection s Lists are synonymous arrays andtwo d interchangeably " + " two declarations are equivalentcolors variable declared usingList syntax " + "List String colors = String " +
            "Alternativelycolors variable declared array but assigned than array " + "String[] colors = String " +
            "Grow collections needed by usingList s square bracket array notation reference existing s incollection by index cant however bracket array notation s " + "This example shows how s when add s " + " s one step " +
            "List String colors = String red blue " +
            " s after has created ";
    String text23 = "List String = String " +
            "moreColors orange " +
            "moreColors purple " +
            "List s read by specifying index between brackets just like array s get read example based onlists created inprevious example shows how read s using methodexample shows how iterate over array s " + " Get s " +
            "String color1 = get " +
            "String color2 = moreColors[0] " +
            "System color1 color2 " +
            " Iterate over read s " +
            "for Integer i=0 i colors i++ " +
            " Write value todebug log " +
            " debug colors[i] " +

            "Note " +
            "BeyondBasics " + " supports two other collection types Set Map learn these inCollections section Guide " + " " +
            "One ofbenefits re methods by triggers other classesfollowing tutorial walks through saving example anization using send emails inspecting debug logs " +
            "Save " +
            "SaveEmailManager anization " + "Open under Name orquick access menu gear icon " +
            "In File | | enter EmailManager forclass name OK " +
            "Replacedefault body wiailManager example " + " EmailManager has public sendMail sends s built Messaging methods library has private inspectResults can’t externally beca private but d withinclass inspectsresults ofemail send by sendMail ";
    String text24 = "public EmailManager " +
            " Public " +
            " public void sendMail String address String subject String body " +
            " mail message " +
            " Messaging SingleEmailMessage = Messaging SingleEmailMessage " +
            " String[] toAddresses = String[] address " +
            " setToAddresses toAddresses " +
            " setSubject subject " +
            " setPlainTextBody body " +
            " Pass message tobuilt sendEmail " +
            " ofMessaging " +
            " Messaging SendEmailResult[] = Messaging sendEmail " +
            " Messaging SingleEmailMessage[] " +
            " inspectreturned " +
            " inspectResults " +

            " " +
            " private Boolean inspectResults Messaging SendEmailResult[] " +
            " Boolean sendResult = true " +
            " sendEmail returns array s " +
            " Iterate throughlist inspect " +
            " classmethods send one ";
    String text25 = " so we one " +
            " Messaging SendEmailResult res " +
            " if res " +
            " debug sent successfully " +

            " " +
            " sendResult = false " +
            " debugfollowing errors occurred + res getErrors " +


            " sendResult " +


            " File | Save save " + "NOTE If isn’t syntactically correct error shows up inProblems error details correct " +
            "Note " +
            "BeyondBasics " +
            " just saved makes oriented OOPclass encapsulatesmethods are related managing perfect example OOPclass would contain member variables attributes accessor methods access those attributes but simplicity our doesn’t these " + "Salesforce compiles when save " +
            "Call Send " + "Let’s invokepublic We’ll anonymous execution do so Anonymous ows lines onfly handy way invoke especially functionality Debug log are generated any other execution " + "Note " +
            "Note " + "There are other ways invoke example through triggers You’ll learn triggers another module " + "In Debug | Open Anonymous Window " +
            "Inwindow opens enterfollowing Replace address address " +
            "EmailManager em = EmailManager ";
    String text26 = "em sendMail address Trailhead Tutorial body " +
            " Now has executed received inbox " +
            "Inspect Debug Logs " + "Debug logs are ful debugging When methods executecalls are logged indebug log write own debug messages tolog helps debugging there are errorsinspectResults by sendMail writes messages tolog by usingSystem debug indicate whetheremail send operation was successful had errors look these messages indebug log was generated when executedmethod " + "In clickLogs double clickmost recent log inlist " +
            "Select Debug filterlog so log lines debug statements are shown Filterdebug log view debug messages " +
            "You’ll seefollowing message infiltered log view assumingemail was sent with errors " + "DEBUG|Email sent successfully " + "Note " +
            "Note " + "Also filterdebug log by searching any keyword inFilter field by selecting any ofother options information seeLog Inspector help " +
            "Call " + "Beca sendMail our doesn’t access member variables doesn’t instance Let’s change by addingstatic keyword its declaration methods are easier than instance methods beca don’t on instance ofclass but are directly onclass name " + "In findopen forEmailManager modifyfirst line ofsendMail definition tofollowingonly change isadded statickeyword " +
            "public void sendMail String address String subject String body " +
            " File | Save save " +
            "Modifystatements Anonymous window callstatic onclass name " +
            "EmailManager sendMail address Trailhead Tutorial body " +
            " Now has executed optionallydebug log inprevious steps ";
    String text27 = "Resources " +
            "Introduction Recorded Webinar " +
            " Guide Introducing " +
            "Trailhead Basics" +
            "Manipulate Records " + "Learning ives " +
            "After completing unit youll able " +
            " insert update delete records " +
            "Perform statements bulk " +
            " upsert insert update record " +
            "Catch Exception " +
            " insert records withpartial success option processresults " +
            "Know when statements when methods " +
            "Perform operations on related records " +
            "Manipulate Records " +
            " modify records Salesforce by usingData Manipulation abbreviated DML provides straightforward way manage records by providing simple statements insert update merge delete restore records " + "Beca foc d saved onLightning Platform has direct access Salesforce Unlike other languages require additional quickly connect sources managing records made easy By calling statements perform operations on Salesforce records example addsAcme Salesforce s created first passed argument toinsertstatement persistsrecord Salesforce " +
            " Createaccount s " +
            "Account acct = Name=Acme Phone= NumberOfEmployees=100 " +
            " Insertaccount by using " +
            "insert acct " +
            "DML Statements " + " statements are available " + "insert " +
            "update ";
    String text28 = "upsert " +
            "delete " +
            "undelete " +
            "merge " +
            "Each statement accepts single s array s s Operating on s s efficient way processing records " + "All within those statements except couple are familiar operationsupsert merge statements are particular Salesforce quite handy " + " upsert operation creates records updates s records single statement using specified field determinepresence existing s orID field if field specified " + " merge statement merges up three records ofsame s type into one ofrecords deletingothers re parenting any related records " + "ID Field Auto Assigned Records " + "When inserting recordssystem assigns ID each record addition persistingID value indatabaseID value auto populated ons variable d argument inDML " + "This example shows how getID ons corresponds toinserted " + " Createaccount s " +
            "Account acct = Name=Acme Phone= NumberOfEmployees=100 " +
            " Insertaccount by using " +
            "insert acct " +
            " Getnew ID oninserted s argument " +
            "ID acctID = acct Id " +
            " Display ID indebug log " +
            "System debug ID = + acctID " +
            " Debug log resultID " +
            " DEBUG|ID = D000000JmKkeIAF " +
            "Note " +
            "BeyondBasics " + "Beca s variable inexample containsID afterDML re s variable perform further operations such updates able maps variable its record by matchingID " + "You retrieve record database obtain its fields includingID field but can’t You’ll write query by using SOQL You’ll learn SOQL another unit " + "Bulk " + "You perform operations on single s bulk on s s Performing bulk operations isrecommended way beca helps avoid hitting governor limits such asDML limit statements per transaction limit place fair access shared resources inLightning Platform Performing operation on s s counts one statement not one statement each s " + "This example inserts contacts bulk by inserting contacts one callsample updates those contacts bulk too " + "Execute snippet using Anonymous " +
            " contacts " +
            "List Contact conList = Contact " +
            " Contact FirstName=Joe LastName=Smith Department=Finance " +
            " Contact FirstName=Kathy LastName=Smith Department=Technology " +
            " Contact FirstName=Caroline LastName=Roth Department=Finance " +
            " Contact FirstName=Kim LastName=Shain Department=Education " +
            " Bulk insert contacts one " +
            "insert conList " +
            " holdnew contacts update " +
            "List Contact listToUpdate = Contact " +
            " Iterate throughlist title " +
            " ifdepartment Finance " +
            "for Contact con conList " +
            " if con Department == Finance " +
            " con Title = Financial analyst " +
            " updated contact s tolist " +
            " listToUpdate con ";
    String text29 =

            " Bulk update contacts one " +
                    "update listToUpdate " +
                    "Inspectcontacts recently created " + "Two ofcontacts who are inFinance department their titles populated Financial analyst " +
                    "Upsert Records " + "If containing mix existing records insertions updates records inlist by usingupsert statement Upsert helps avoidcreation duplicate records save don’t determine records exist first " + " upsert statement matchess s existing records by comparing values one field If don’t specify field when calling statementupsert statement ss ’s ID matchs existing records Salesforce Alternatively specify field matching s specify field marked external ID standard s specify any field hasidLookup property set true exampleEmail field Contact r hasidLookup property set field’s property see Reference Salesforce Lightning Platform " + "Upsert Syntax " + "upsert s | s [] " + "upsert s | s [] field " + " optional field field token example specifyMyExternalID fieldstatement " +
                    "upsert s List Fields MyExternalId " +
                    "Upsert ss records primary keyID idLookup field external ID field determine whether record update existing one " + "Ifkey not matched record created " +
                    "Ifkey matched onceexisting record updated " +
                    "Ifkey matched multiple s error generated and record neither inserted updated " +
                    "This example shows how upsert updates existing contact record inserts contact one upsert updatesexisting Josh contact inserts contact Kathy " + "Note " +
                    "Note " + " upsert sID matchfirst contactjosh variable being re d forupsert variable has already populated withrecord ID previous insert soID doesn’t set explicitly example " + "Execute snippet inExecute Anonymous window " +
                    " InsertJosh contact " +
                    "Contact josh = Contact FirstName=Josh LastName=Kaplan Department=Finance " +
                    "insert josh " +
                    " Joshs record has inserted " +
                    " sovariable josh has now ID " +
                    " d matchrecords by upsert " +
                    "josh Description = Josh record has updated byupsert operation " +
                    " CreateKathy contact but dont persist indatabase " +
                    "Contact kathy = Contact FirstName=Kathy LastName=Brown Department=Technology " +
                    " holdnew contacts upsert " +
                    "List Contact contacts = Contact josh kathy " +
                    " upsert " +
                    "upsert contacts " +
                    " Josh updated Kathy created " +
                    "Inspect contacts " + "Your one Josh Kaplan record not two beca upsert operation foundexisting record updated instead creating contact record One Kathy Brown contact record there too " +
                    "Alternatively specify field d matching records example sEmail field on Contact beca has idLookup property setexample insertsJane Smith contact creates second Contact s populates withsame calls upsert updatecontact by usingemail field matching " + "Note ";
    String text30 = "Note " + "If insert was d example instead upsert duplicate Jane Smith contact would inserted " + "Execute snippet inExecute Anonymous window " +
            "Contact jane = Contact FirstName=Jane " +
            " LastName=Smith " +
            " Email=jane smith@example com " +
            " Description=Contact ofday " +
            "insert jane " +
            " Upsert using idLookup field " +
            " second s variable " +
            " variable doesn’t any ID set " +
            "Contact jane2 = Contact FirstName=Jane " +
            " LastName=Smith " +
            " Email=jane smith@example com " +
            " Description=Prefers contacted by " +
            " Upsertcontact by usingidLookup field matching " +
            "upsert jane2 Contact fields " +
            " thatcontact has updated " +
            "System Prefers contacted by " +
            " [SELECT Description Contact WHERE Id= jane Id] Description " +
            "Inspect contacts " + "Your one Jane Smith contact withupdated description " +
            "Delete Records " + "You delete persisted records usingdelete statement Deleted records aren’t deleted permanently Lightning Platform but placed inRecycle Bin days where restored " + "This example shows how delete contacts whose last name Smith If you’ve sample bulk already two contacts withlast name Smith snippet using Anonymous there are contacts withlast name Smith anymore " + "Contact[] contactsDel = [SELECT Id Contact WHERE LastName=Smith] " +
            "delete contactsDel " +
            "Note " +
            "Note " + "This snippet query retrievecontacts SOQL query You’ll learn SOQL another unit " + "DML Statement Exceptions " + "If operation fails returns exception type DmlException exceptions handle error conditions " + "This example produces DmlException beca attempts insert with required Name fieldexception caught incatch block " + "try " +
            " exception beca ";
    String text31 = "required Name field not provided " +
            " acct = " +
            " Insertaccount " +
            " insert acct " +
            " DmlException e " +
            " debug exception has occurred + " +
            " e getMessage " +

            "Database Methods " +
            " containsbuilt provides methods perform operations mirrorDML statement counterparts " +
            "These methods are are onclass name " + "Database insert " +
            "Database update " +
            "Database upsert " +
            "Database delete " +
            "Database undelete " +
            "Database merge " +
            "Unlike statements methods optional OrNone parameter ows specify whetheroperation partially succeed When parameter set false if errors occur on partial set recordssuccessful records committed errors returned forfailed records exceptions are thrown withpartial success option " + "This how callinsert withallOrNone set false " + "Database insert recordList false " +
            " methods s containing success failure information each record example insert update operations each array SaveResult s " + "Database SaveResult[] = insert recordList false " +
            "Note " +
            "Note " + "Upsert returns UpsertResult s delete returns DeleteResult s " + "By defaultallOrNone parameter true means thatDatabase behaves like its statement counterpart throw exception if failure encountered " + " two statements are equivalent toinsert recordList statement " + "Database insert recordList " +
            "And " + "Database insert recordList true " +
            "Note " +
            "BeyondBasics " + "In addition these methodsDatabase contains methods aren’t provided statements example methods d transaction control rollback emptyingRecycle Bin methods related SOQL queries You’ll learn SOQL another unit " + "Example Insert Records Partial Success " + "Let’s take look at example sDatabase methods example based onbulk example but replacesDML statement methodDatabase insert withpartial success option One contact inlist doesn’t any fields on purpose ca error beca contact can’t saved with required LastName field Three contacts are committed andcontact with any fields generates errorlast part example iterates throughreturned writes debug messages todebug log " + "Execute example inExecute Anonymous window " +
            " contacts " +
            "List Contact conList = Contact " +
            " Contact FirstName=Joe LastName=Smith Department=Finance " +
            " Contact FirstName=Kathy LastName=Smith Department=Technology " +
            " Contact FirstName=Caroline LastName=Roth Department=Finance " +
            " Contact " +
            " Bulk insert contacts one " +
            "Database SaveResult[] srList = insert conList false " +
            " Iterate through each returned ";
    String text32 = "for SaveResult sr srList " +
            " if sr " +
            " Operation was successful so getID ofrecord was processed " +
            " debug Successfully inserted contact Contact ID + sr getId " +
            " " +
            " Operation failed so get errors " +
            " Error err sr getErrors " +
            " debugfollowing error has occurred " +
            " debug err getStatusCode + + err getMessage " +
            " debug Contact fields affected error + err getFields " +
            "\t " +


            "Verifydebug messages DEBUG keyword forfilter " + "One failure reported three contacts inserted " +
            "Should Statements Methods " + " statements if want any error occurs during bulk processing thrown exception immediately interrupts control flow by using try blocks behavior similar toway exceptions are handled most procedural languages " +
            " methods if want ow partial success bulk operation—if record failsremainder ofDML operation succeed application You inspect rejected records possibly retryoperation When using form write never throws exception errors Instead appropriate array judge success failure Note methods include syntax supports thrown exceptions similar statements " +
            "Work Related Records " +
            " manage records are related each other through relationships " + "Insert Related Records " + "You insert records related existing records if relationship has already defined betweentwo s such lookup master detail relationship record associated related record through foreign key ID example if inserting contact specifycontacts related record by settingvalue ofAccountId field " + "This example shows how contact accountrelated record by settingAccountId field oncontact Contact are linked through lookup relationship " + "Execute snippet inAnonymous window " +
            "Account acct = Name=SFDC " +
            "insert acct " +
            " Once inserteds " +
            " populated ID " +
            " Get ID " +
            "ID acctID = acct ID " +
            " contact ";
    String text33 = "Contact mario = Contact " +
            " FirstName=Mario " +
            " LastName=Ruiz " +
            " Phone=415 " +
            " AccountId=acctID " +
            "insert mario " +
            "Inspectcontacts " + "A SFDC has created hasMario Ruiz contact inaccount’s Contacts related " +
            "Update Related Records " + "Fields on related records cant updated withsame toDML operation require separate example if inserting contact specifycontacts related record by settingvalue ofAccountId field However cant changeaccounts name with updatingaccount itself separate Similarly when updating contact if want updatecontact’s related must make two callsfollowing example updates contact its related using two update statements " +
            " Query forcontact has associated " +
            "Contact queriedContact = [SELECT Name " +
            " Contact " +
            " WHERE FirstName = Mario LastName=Ruiz " +
            " LIMIT ] " +
            " Updatecontacts phone number " +
            "queriedContact Phone = " +
            " Updaterelated industry " +
            "queriedContact Industry = Technology " +
            " Make two separate calls " +
            " updatecontacts phone " +
            "update queriedContact " +
            " updaterelated accounts Industry field " +
            "update queriedContact " +
            "Delete Related Records " + " delete operation supports cascading deletions If delete parent delete its children automatically long each child record deleted " + "For example deletingaccount created earlier SFDC delete its related contact too " + "Execute snippet inAnonymous window " +
            "Account[] queriedAccounts = [SELECT Id WHERE Name=SFDC Account] " +
            "delete queriedAccounts " +
            " accounts contacts " + "You’ll see bothaccount its related contact were deleted " +
            "Ab Transactions " + "DML operations transaction operations transaction complete successfully if error occurs one operationentire transaction rolled back committed todatabaseboundary transaction trigger anonymous block page Web service example if trigger creates two accounts updates one contact andcontact update fails beca validation rule failureentire transaction rolls back none ofaccounts are persisted Salesforce " + "Resources ";
    String text34 = " Guide " +
            " Guide Working " +
            " Guide Adding Retrieving " +
            " Guide Class" +
            "Write SOQL Queries " + "Learning ives " +
            "After completing unit youll able " +
            "Write SOQL queries " +
            "Execute SOQL queries by usingQuery Editor " +
            "Execute SOQL queries embedded by using Anonymous " +
            "Query related records " +
            "Get Started SOQL " +
            "To read record Salesforce must write query Salesforce providesSalesforce Query SOQL short read saved records SOQL similar tostandard SQL but ized forLightning Platform " + "Beca has direct access Salesforce records are stored indatabase embed SOQL queries get straightforward fashion When SOQL embedded referred inline SOQL " + "To include SOQL queries wrapSOQL statement brackets assignreturn value array s s examplefollowing retrieves records two fields Name Phone returns array s s " +
            "Account[] = [SELECT Name Phone Account] " +
            "Prerequisites " + "Some queries unit expect accounts contacts queries sample " + "In openExecute Anonymous window Debug menu " +
            "Insertbelow snippet inwindow " +
            " related contact ";
    String text35 = "Account acct = " +
            " Name=SFDC Computing " +
            " Phone= " +
            " NumberOfEmployees=50 " +
            " BillingCity=San Francisco " +
            "insert acct " +
            " Onceaccount inserteds " +
            " populated ID " +
            " Get ID " +
            "ID acctID = acct ID " +
            " contact " +
            "Contact con = Contact " +
            " FirstName=Carol " +
            " LastName=Ruiz " +
            " Phone= " +
            " Department=Wingo " +
            " AccountId=acctID " +
            "insert con " +
            " contact " +
            "Account acct2 = " +
            " Name= SFDC Query Man " +
            " Phone= " +
            " NumberOfEmployees=50 " +
            " BillingCity=Los Angeles " +
            " Description=Expert wing technologies " +
            "insert acct2 " +
            " Query Editor " + " providesQuery Editor SOQL queries view resultsQuery Editor provides quick way inspectdatabase way SOQL queries adding When Query Editor must supply onlySOQL statement with surrounds " + "Let’s try ningfollowing SOQL example " + "In clickQuery Editor " +
            "Copy pastefollowing intofirst box under Query Editor " +
            "SELECT Name Phone " +
            "All records appear inQuery section rows fields " + "Basic SOQL Syntax " +
            "This issyntax basic SOQL query " + "SELECT fields Name [WHERE Condition] " +
            " WHERE cla optional Let’s start very simple query examplefollowing query retrieves accounts gets Name Phone fields each " + "SELECT Name Phone " +
            " query has two parts " + "SELECT Name Phone part listsfields would like retrievefields are specified afterSELECT keyword comma delimited specify one field comma necessary e g SELECT Phone " +
            " part specifiesstandard want retrieve example it’s Invoice_Statement Invoice_Statement__c " +
            "Note ";
    String text36 =
            "BeyondBasics " + "Unlike other SQL languages can’t specify fields must specify every field want get explicitly If try access field haven’t specified inSELECT cla you’ll get error beca field hasn’t retrieved " + "You don’t specifyId field inquery always returned queries whether specified inquery not example SELECT Id Phone SELECT Phone are equivalent statementsonly want specifyId field if isonly field you’re retrieving beca at least one field SELECT Id want specifyId field when ning query inQuery Editor asID field won’t displayed unless specified " + "Filter Query Conditions " + "If than one returned If want limitaccounts returned accounts fulfill certain condition condition insideWHERE cla following example retrieves onlyaccounts whose names are SFDC Computing Note comparisons on strings are insensitive " + "SELECT Name Phone WHERE Name=SFDC Computing " +
                    " WHERE cla contain multiple conditions are grouped by using logical operators parentheses example query returns accounts whose name SFDC Computing than employees " + "SELECT Name Phone WHERE Name=SFDC Computing NumberOfEmployees " +
                    "This another example complex condition query returns these records " + "All SFDC Computing accounts " +
                    "All accounts than employees whose billing city Los Angeles " +
                    "SELECT Name Phone WHERE Name=SFDC Computing NumberOfEmployees BillingCity=Los Angeles " +
                    "Note " +
                    "BeyondBasics " + "Instead usingequal operator = comparison perform fuzzy matches by usingLIKE operator example retrieve accounts whose names start SFDC by using condition WHERE Name LIKE SFDC wildcard character matches any character_ character contrast d match just one character " + "Order Query " + "When query executes returns records Salesforce particular order so can’t rely onorder records inreturned array besame each query however choose sortreturned record set by adding ORDER BY cla specifyingfield by whichrecord set sorted example sorts retrieved accounts based onName field " + "SELECT Name Phone ORDER BY Name " +
                    " default sort order alphabetical order specified ASCprevious statement equivalent " + "SELECT Name Phone ORDER BY Name ASC " +
                    "To reverseorder DESC keyword descending order " + "SELECT Name Phone ORDER BY Name DESC " +
                    "You sort on most fields including numeric text fields can’t sort on fields like rich text multi select picklists " + "Try these SOQL statements inQuery Editor see howorder ofreturned record changes based onName field " + "LimitNumber Records Returned " + "You limitnumber records returned arbitrary number by addingLIMIT n cla where n isnumber records want returned Limitingresult set handy when don’t care records are returned but just want work subset records example query retrievesfirst returned Notice thatreturned value one not array when using LIMIT " + "Account oneAccountOnly = [SELECT Name Phone LIMIT ] " +
                    "Combine Pieces " +
                    "You combineoptional cla s one query infollowing order " + "SELECT Name Phone " +
                    " WHERE Name = SFDC Computing NumberOfEmployees " +
                    " ORDER BY Name " +
                    " LIMIT " +
                    "Executefollowing SOQL query by usingExecute Anonymous window inspectdebug statements indebug log One sample returned " + "Account[] = [SELECT Name Phone " +
                    " WHERE Name=SFDC Computing NumberOfEmployees " +
                    " ORDER BY Name " +
                    " LIMIT ] ";
    String text37 =
            "System debug + returned " +
                    " Write array info " +
                    "System debug " +
                    "Access Variables SOQL Queries " + "SOQL statements reference variables expressions if are preceded by colon local variable SOQL statement bind " + "This example shows how targetDepartment variable inWHERE cla " + "String targetDepartment = Wingo " +
                    "Contact[] techContacts = [SELECT FirstName LastName " +
                    " Contact WHERE Department= targetDepartment] " +
                    "Query Related Records " + "Records Salesforce linked each other through relationships lookup relationships master detail relationships exampleContact has lookup relationship When update contact associate accountcontacts are associated withsame appear related onaccount’s page Insame way view related records inSalesforce r interface query related records SOQL " + "To get child records related parent record inner query forchild records cla ofinner query againstrelationship name than Salesforce name example contains inner query get contacts are associated each returned account cla specifiesContacts relationship default relationship on links accounts contacts " + "SELECT Name SELECT LastName Contacts WHERE Name = SFDC Computing " +
                    "This next example embedsexample SOQL query shows how getchild records SOQL by usingContacts relationship name ons " + "Account[] WithContacts = [SELECT Name SELECT FirstName LastName Contacts " +
                    " " +
                    " WHERE Name = SFDC Computing] " +
                    " Get child records " +
                    "Contact[] cts = WithContacts[0] Contacts " +
                    "System debug Name first associated contact " +
                    " + cts[0] FirstName + + cts[0] LastName " +
                    "You traverse relationship child contact field on its parent Name by using dot notation examplefollowing snippet queries contact records whose first name Carol able retrievename Carol’s associated by traversingrelationship between accounts contacts " + "Contact[] cts = [SELECT Name Contact " +
                    " WHERE FirstName = Carol LastName=Ruiz] " +
                    "Contact carol = cts[0] " +
                    "String acctName = carol Name " +
                    "System debug Carol\\s name + acctName " +
                    "Note " +
                    "Note " + " examples section are based on standard s s linked by using relationships relationship names end with__r suffix example invoice statements are linked line items throughLine_Items__r relationship onInvoice_Statement__c " + "Query Record Batches By Using SOQL Loops " + "With SOQL loop include SOQL query loopresults SOQL query iterated over withinloop SOQL loops retrieving records—records are retrieved using efficient chunking calls toquery queryMore methods ofSOAP API By using SOQL loops avoid hittingheap limit " + "SOQL loops iterate over ofs records returned by SOQL querysyntax SOQL loop " +
                    "for variable [soql_query] " +
                    " code_block " +

                    "or " +
                    "for variable_list [soql_query] " +
                    " code_block ";
    String text38 =

            "Both variable variable_list must ofsame type ass s are returned bysoql_query " + "It preferable s format ofSOQL loop asloop executes each batch s s Doing so work on batches records perform operations batch helps avoid reaching governor limits " + "insert Account[]new Name = loop " +
                    " Name = loop " +
                    " Name = loop " +
                    "s format executesfor loop per returned batch " +
                    " records " +
                    "Integer i=0 " +
                    "Integer j=0 " +
                    "for Account[] tmp [SELECT Id WHERE Name LIKE loop _] " +
                    " j = tmp " +
                    " i++ " +

                    "System jlist containedthree accounts " +
                    " named yyy " +
                    "System i Since single batch hold up records " +
                    " three records returned" +
                    " loop executed " +
                    "Resources " +
                    "SOQL SOSL Reference" +
                    "Write SOSL Queries " + "Learning ives " +
                    "After completing unit youll able " +
                    "Describedifferences between SOSL SOQL " +
                    "Search fields across multiple s using SOSL queries " +
                    "Execute SOSL queries by usingQuery Editor " +
                    "Get Started SOSL " +
                    "Salesforce SOSL Salesforce d perform text searches records SOSL fields across multiple standard records Salesforce SOSL similar Apache Lucene " + "Adding SOSL queries simple—you embed SOSL queries directly When SOSL embedded referred inline SOSL " + "This example SOSL query searches accounts contacts any fields withword SFDC " +
                    "List S searchList = [FIND SFDC FIELDS " +
                    " RETURNING Name Contact FirstName LastName ] " +
                    "Differences Similarities Between SOQL SOSL " + "Like SOQL SOSL ows anization’s records specific information Unlike SOQL query one standard at single SOSL query s " + "Another difference SOSL matches fields based on word match while SOQL performs exact match by default when not using wildcards example searching Digital SOSL returns records whose field values are Digital orDigital Company but SOQL returns records field values Digital " + "SOQL SOSL are two separate languages different syntax Each has distinct " + " SOQL retrieve records single " +
                    " SOSL fields across multiple s SOSL queries most text fields on " +
                    "Prerequisites " + "Some queries unit expect accounts contacts If haven’t createdsample inSOQL unit sample unit Otherwise skip creatingsample section " + "In openExecute Anonymous window Debug menu " +
                    "Insertbelow snippet inwindow " +
                    " related contact " +
                    "Account acct = " +
                    " Name=SFDC Computing " +
                    " Phone= " +
                    " NumberOfEmployees=50 " +
                    " BillingCity=San Francisco " +
                    "insert acct " +
                    " Onceaccount inserteds " +
                    " populated ID " +
                    " Get ID " +
                    "ID acctID = acct ID " +
                    " contact " +
                    "Contact con = Contact " +
                    " FirstName=Carol " +
                    " LastName=Ruiz " +
                    " Phone= " +
                    " Department=Wingo " +
                    " AccountId=acctID " +
                    "insert con " +
                    " contact " +
                    "Account acct2 = " +
                    " Name= SFDC Query Man " +
                    " Phone= " +
                    " NumberOfEmployees=50 " +
                    " BillingCity=Los Angeles " +
                    " Description=Expert wing technologies " +
                    "insert acct2 ";
    String text39 =
            " Query Editor " + " providesQuery Editor SOSL queries view resultsQuery Editor provides quick way inspectdatabase way SOSL queries adding When Query Editor supply onlySOSL statement with surrounds " + "Let’s try ningfollowing SOSL example " + "In clickQuery Editor " +
                    "Copy pastefollowing intofirst box under Query Editor " +
                    "FIND Wingo FIELDS RETURNING Name Contact FirstName LastName Department " +
                    "All contact records satisfycriteria display inQuery section rows fieldsresults are grouped tabs each contactSOSL query returns records fields whose values match Wingo Based on our sample one contact has field withvalue Wingo so contact returned " + "Note " +
                    "Note " + " query inQuery Editor andAPI must enclosed curly brackets Wingo contrast query enclosed single quotes Wingo " + "Basic SOSL Syntax " +
                    "SOSL ows specifyfollowing criteria " +
                    "Text expression single word phrase " +
                    "Scope fields " +
                    "List s fields retrieve " +
                    "Conditions selecting rows insource s " +
                    "This issyntax basic SOSL query " + "FIND SearchQuery [IN SearchGroup] [RETURNING sAndFields] " +
                    "Remember inQuery Editor APIsyntax slightly different " + "FIND SearchQuery [IN SearchGroup] [RETURNING sAndFields] " +
                    "SearchQuery istext single word phrase terms grouped logical operators parentheses terms include wildcard characters wildcard matches zero characters atmiddle end ofsearch term wildcard matches one character atmiddle end ofsearch term " + "Text searches are insensitive example searching er er ER returnsame " + "SearchGroup optional isscope offields If not specifieddefault scope fields SearchGroup take one offollowing values " + "ALL FIELDS " +
                    "NAME FIELDS " +
                    "EMAIL FIELDS " +
                    "PHONE FIELDS " +
                    "SIDEBAR FIELDS " +
                    " sAndFields optional isinformation insearch result—a one s s each s one fields optional values filter against If not specifiedsearch containIDs s " + "Single Phrases " + "A SearchQuery contains two types text " + "Single Word— single word such hello inSearchQuery are delimited by spaces punctuation changes letters digits vice versa are always insensitive " +
                    "Phrase— collection spaces surrounded by double quotes such john smith Multiple combined logic grouping operators form complex query ";
    String text40 = "Search Examples " + "To learn how SOSL works let’s play different strings see what put based on our sample table lists various example strings andSOSL " + "Search fields \tSearch Description\tMatched Records Fields " +
            " Query\tThis returns records whose fields contain both wordsand Query any location oftextorder insearch term doesn’t matter \tAccountSFDC Query Man Name field matched " +
            "Wingo Man\tThis sOR logical operator returns records fields containingword Wingo records fields containingword Man \tContact Carol Ruiz Department Wingo " +
            "AccountSFDC Query Man Name field matched " + "1212\tThis returns records whose fields containword Phone fields end are matched beca considered word when delimited bydash \tAccountSFDC Query Man Phone " +
            "Contact Carol Ruiz Phone " + "wing\tThis wildcard returns records field value starting wing \tContact Maria Ruiz Department Wingo " +
            "AccountSFDC Query Man Description Expert wing technologies " + "SOSL Example " +
            "This example shows how SOSL query Firstvariable soslFindCla assignedsearch query consists two terms Wingo SFDC combined byOR logical operatorSOSL query references local variable by preceding colon bindingresulting SOSL query searches Wingo SFDC any field example returns sample accounts beca each field containing one ofwordsSOSL are returned lists Each contains array ofreturned records caselist has two s At index containsarray accounts At index containsarray contacts " + "Execute snippet inExecute Anonymous window Next inspectdebug log records are returned " + "String soslFindCla = Wingo SFDC " +
            "List s searchList = [FIND soslFindCla FIELDS " +
            " RETURNING Name Contact FirstName LastName Department ] " +
            "Account[] searchAccounts = Account[] searchList[0] " +
            "Contact[] searchContacts = Contact[] searchList[1] " +
            "System debug Foundfollowing accounts " +
            "for searchAccounts " +
            " debug Name " +

            "System debug Foundfollowing contacts " +
            "for Contact c searchContacts " +
            " debug c LastName + + c FirstName " +

            " Me More " +
            "You filter reorder limitreturned SOSL query Beca SOSL queries multiple s s those filters are applied each s insideRETURNING cla " + "You filter SOSL by adding conditions inWHERE cla example accounts whose industry Apparel returned RETURNING Name Industry WHERE Industry=Apparel " + "Likewise ordering one s supported by adding ORDER BY example ca sreturned accounts ordered byName field RETURNING Name Industry ORDER BY Name " + " number returned records limited subset records example limitsreturned accounts RETURNING Name Industry LIMIT " + "Resources " +
            "SOQL SOSL Reference" +
            "Handle Actions Controllers " +
            "Learning ives ";
    String text41 =
            "After completing unit you’ll able " +
                    " client side controller handle r actions " +
                    "Read values attributes " +
                    "Read values r interface controls " +
                    "Write controller JavaScript changes r interface " +
                    "Handling Actions Controllers " +
                    "Up now we’ve worked XML style markup Up nowonly way our ’s put change was change markup Up now our didn’t react r input Up now we haven’t written any JavaScript " + "That changes unit " + "To get started let’s look at very simple imagine what needs do able handle its simple behavior " + "Message ofday look nice today button Today going great day button " +
                    "This helloMessageInteractive it’s hard imagine simpler “does something ” It’s bit text currently blank message two buttons Here’scode " + " aura " +
                    " aura attribute name= message type= String " +
                    " p Message ofday v message p " +
                    " div " + "This look familiar we’ve really added two lightning button helloMessage When buttonmessage ofday updated " + "Well not quite yet If you’ve already enteredcode tried yourself you’ve noticed when ofbuttons get error message " + "There problem " +
                    "We’ll befirst admit not every error message you’ll see Lightning helpful might hope But one says there’s controller" +
                    " action named “handleClick” Where does “handleClick” come comes expression we assigned toon attribute on each oftwo lightning button tags " + "Given button probably guess thaton attribute how assign behavior tobutton when it’s clicked But what we assigned expression c handle that’s be bit mysterious " + "It’s actually pretty simple Just likev message expression earlier c handle value provider c property handle c isvalue provider for’s client side controller handle function defined controller So c handle reference action handler in’s controller " + "c handle c value provider for controller withproperty handle function defined controller " +
                    "Uh What’s Controller " +
                    "Whoops controller basically collection defines app’s behavior when “things happen ” whereby “things” we mean r input r other events updates so on If look up “Model View Controller” on any number sites you’ll get various definitions our purposes Lightning controller resource bundle holdsaction handlers action handlers are just JavaScript functions particular function signature " + "BeyondBasics " +
                    "We talk lot controllers unit we know that itself view We mentionedMVC Model View Controller design pattern that’s so common web frameworks Lightning built onMVC pattern " + "In word There are similarities sure but would correct say Lightning View Controller Controller Model perhaps View Controller Controller Database " + "Why “controller” doubled up pattern name Beca when interacting Salesforce server side controller addition toclient side controller we’ve worked unit dual controller design iskey difference between Lightning MVC " + "What’sdistinction between “model” “database” traditional MVCmodel programmatic abstraction usually betweenunderlying storage usually relational andrest ofapplication Lightning there’s directly stands between @AuraEnabled controller methods operations But again s s are already abstraction between andunderlying storage layer calculation fields validation logic fully programmatic behavior inform triggers So model We say po TAY tow but it’s totally cool if want go po TAH tow " + "Conf d Excited We’ll get sorted ondetails server side controllers later unit " + "Let’s look athelloMessageInteractive controller detail make explanation bit concrete " + " " +
                    " handle function event " +
                    " let btnClicked = event getSourcebutton " +
                    " let btnMessage = btnClicked get v labelbuttons label " +
                    " set v message btnMessage update our message ";
    String text42 =
            "Controller resources interesting format are JavaScript s contain map name value pairs wherename isname ofaction handler andvalue function definition " + "Action Handlers " +
                    " combination name value pair specific function signature action handler You’ll hear seeterms action handler controller action controller function d interchangeably formost part that’s correct almost always refer tosame thing We’re not going worry ab exceptions module " + "Don’t worry too much ab special format ofcontroller resource When clickCONTROLLER button you’ll get controller resource example action handler already addedone trick is—and get syntax errors if f et—you put commas between action handlers just basic JavaScript syntax we’ll seespecifics bit " + " actual handle function four lines but might seem hard understand at first At high level it’s simple Whenbutton clicked its action handler gets Inaction handlercontroller getsbutton was clicked pullslabel text sets’s message attribute text Andmessage ofday updated Today going great day " + "Inaction handlercontroller getsclicked button text sets message attribute " +
                    "Simple right Well… " + "Beca super important let’s break down line by line " + "handle function event " +
                    " action handler name followed by anonymous function declarationimportant thing here isfunction signature While it’s not technically required always declare controller functions take these three parameters We’ll talk we go but now these parameters represent " + "— it’s helloMessageInteractive " +
                    "event— event ca daction handler " +
                    "helper— ’s another JavaScript resource reusable functions " +
                    " let btnClicked = event getSourcebutton " +
                    "Remember handle connected our lightning button tag its on attributeevent someone clickingbutton Inside event hasnotion sourcething generatedevent isbutton itself So calling event getSource gets us reference tospecific lightning button was clicked " + " let btnMessage = btnClicked get v labelbuttons label " +
                    "What do we do now we reference tobutton We look inside get its label set onlightning button in markup example lightning button label= look nice today " + "Let’s think bit We don’t havedefinition lightning button front us but label just another attribute much likemessage attribute we added helloMessageInteractive get on any providename ofattribute want retrieve informat v attributeNameresult isattribute value " + "Note markup v representsview itself—but it’slightning button child not helloMessageInteractive Think way btnClicked get v label taps onshoulder whatever btnClicked says “Hey give v label” thinks “v ” looks inside itself returnsvalue its label attribute " + "So now we text string retrieved button we just one step left change our message attribute tonew message text Unsurprisingly just get reads value set writes value " + " set v message btnMessage update our message " +
                    "However let’s notice one important difference We get on btnClickedlightning button that’s inside helloMessageInteractive We’re calling set on — helloMessageInteractive itself pattern you’ll repeat virtually every get values child be do processing set values in itself " + " Aura View Controller Model " +
                    "OK gut making sense sure If just think so make sure you’ve actually createdhelloMessageInteractive usingpreceding It’s one pastingcode takes two minutes but being able play essential understanding handling actions " + "What you’ve here might seem very simple beca it’s not very many lines But these lines illustrate offundamental concepts building apps Aura " + "You think hooking up action handlers “wiring up ” Think helloMessageInteractive simple electrical circuit There are switches there are light bulbsLightning framework suppliespower By itself switch might make nice clicking sound but until wire up it’s not very functional havetrendiest Edison style light bulb but until wire up doesn’t illuminate anything " + "And so Aura Way back ago we said thatdifferent resources bundle are “auto wired” each other that’s truewiring takesform ofv c value providers automatically created made available so controller reference vice versa But auto wiring takes place at high level—in helloMessageInteractive between cmp resource andcontroller js resource isgreen arrow infollowing illustration " + "helloMessageInteractive its controller are auto wired " +
                    " wiring hook up specific lightning button specific action handler—that wiring things generate events such buttons tothings handle events like specific controller function—that’s wiring do yourself fact just did yourself These arered arrows complete working circuit " + "Adding c handle toon attribute lightning button wires up tospecific action handler Calling set v message newMessage wires upresult action handler to’s message attribute itself wired up v message expression " + "You further think ofon event electron flowing alongcircuit you’ve created If haven’t created complete circuitevent doesn’t go anywhere nothing happens When start writing own keep mind Do complete circuit Are sure When doubt sometimes helps sketch on whiteboard paper confirm every connection " + "You’ll wire events handlers at low high levels so often you’ll feel like electrician givenname offramework be Ben Franklin Wiring things fundamental toAura model " + "So let’s do After practice makes perfect " + "Function Chaining Rewiring Simple Debugging " +
                    "Our first version handle was three lines beca we broke each step inget set pattern into separate lines something function chaining collapse those into fewer lines Since you’ll probably see other Lightning let’s give whirl ourselves Addfollowing additional helloMessageInteractive controller after handle " + " handleClick2 function event " +
                    " let newMessage = event getSource get v label " +
                    " set v message newMessage " +

                    " handleClick3 function event " +
                    " set v message event getSource get v label " +

                    "Whoopsie Did just get syntax error when trying save Remember earlier when we said commas between action handlers That’sissue here comma afterfinal brace “ ” handle see atend handleClick2 inpreceding snippet " + "These action handlers do exactlysame thing handle fewer lines do by skipping intermediate variables often by “chaining” directly tonext function by adding toend ofprevious one separated by period concept most clear when looking atdifferences between handle handleClick2 " + "Which style prefer matter personal taste perhaps anization’s coding style humble author prefers handleClick2 separatingget set but not bothering variable forbutton we its label text " + "Of course can’t thatnew action handlers work until wire lightning button one by settingon attribute c handleClick2 c handleClick3 Think disconnectingwires one light bulb attaching light bulb It’s easy " + "At reloadone ofrewired buttons and…well it’ssame by design isn’t it How we action handler being " + "Sometimes simple best Let’s bit logging one ofaction handler functions " + " handleClick2 function event " +
                    " let newMessage = event getSource get v label " +
                    " log handleClick2 Message + newMessage " +
                    " set v message newMessage " +

                    "Now if wire up lightning button handleClick2 you’ll see log message browser’s JavaScript whenever " + "Yes there are sophisticated debugging tools but printing things toconsole honored debugging technique If want put sort wrap JSON stringify your get ful details When you’re after quick peek log friend " + "We won’t cover those sophisticated debugging tools techniques here but see Resources great tools instructions " + "OK helloMessageInteractive was stupid simple has hard coded relentlessly positive attitude Innext unit we’ll work something complex learn how capture real r input since people inreal world aren’t always so positive we’ll learn how validate their input too " + "Resources " +
                    "Working Base Lightning " +
                    "Event Handling Base Lightning " +
                    "lightning button Documentation " +
                    "lightning input Documentation ";
    String text43 =
            "Actions Events " +
                    "Handling Events Client Side Controllers " +
                    "Which Button Was Pressed " +
                    "Enable Debug Lightning " +
                    "Connect Events " +
                    "Learning ives " +
                    "After completing unit you’ll able " +
                    "Define events apps " +
                    " fire events controller " +
                    " action handlers handle events other send " +
                    "Refactor big into smaller " +
                    "Connect Events " +
                    "In unit we’re going tacklelast piece unfinished functionality our little expenses appReimbursed box You’re probably thinking implementing box would short topic We could certainly take shortcuts make very short topic " + "But unit addition making box work removing ofshortcuts we’ve already taken We’re going spend unit “Doing Right ” few places means refactoring work we did earlier " + "Before we start on let’s first talk ab shortcuts we tookRight Way whyRight Way little bit harder but better " + "Composition Decomposition " +
                    "If take look at our little expenses source form listseparate artifacts you’ll come up something likefollowing " + "expenses " +
                    "expenses cmp " +
                    "expensesController js " +
                    "expensesHelper js " +
                    "expensesList " +
                    "expensesList cmp " +
                    "expenseItem " +
                    "expenseItem cmp " +
                    "ExpensesController server side " +
                    "ExpensesController " +
                    "Here’s how everything comes withcreateExpense updateExpense events you’re wiring up later " + " expenses made up many smaller " +
                    "But if look aton screen what do see What see what you’ll eventually see everywhere look thatbreaks down into many You’ll see decompose our further into smaller pieces than we’ve so Atvery least we hope see thatAdd Expense form really its own separate That’s why we drew box around in r interface " + "Why didn’t we make form separate Not doing independent by farbiggest shortcut we took overcourse module It’s worse thanhack we “disgusting ” terms software designright way build Lightning compose build level features Why didn’t we take approach " + "We tookshortcut we keptAdd Expense form insidemain expenses beca keptmain expenses array attribute andcontroller affected insame We wantedcreateExpense function able touchexpenses array directly If we’d movedAdd Expense form into separate wouldn’t possible " + "Why not We coveredreason briefly very early on but we want really hammer on now Lightning are supposed self contained are stand alone s encapsulate their essential functionality not owed reach into another child alter its internals " + "There are two principal ways interact affect another first way one we’ve seen quite bit already setting attributes on’s tag ’s public attributes constitute one part its API " + " second way interact through events Like attributes declareevents send andevents handle Like attributes these public events constitute part of’s public API We’ve actually d handled events already butevents hiding behind convenience features unit we’ll drag events intolight few our own " + " Wiring Circuit Metaphor Yet Again " +
                    "These two mechanisms—attributes events—areAPI “sockets ”ways connect form complete circuits Events are behindsceneselectrons flowing through circuit But that’s one way events are different attributes " + "When seton attribute on lightning button action handler ’s controller direct relationship between those two are linked while using public APIs remain each other coupled " + "Events are different don’t send events another That’s not how events work broadcast events particular type If there’s responds type event if “hears” event act on " + "You think ofdifference between attributes events asdifference between wired circuits wireless circuits we’re not talking wireless phones here One doesn’t get“number” another up would attribute events are like wireless broadcasts gets onradio sends message there anyone there their radio set turned on tuned toright frequency has way knowing—so write such way it’s OK if one hearsevents broadcast things might not work but nothing crash " + "Sending Event " +
                    "OK enough theory let’s do something specific our see how events work We start by implementingReimbursed box we’ll take what we learned doing refactorAdd Expense form into its own wayGreat Engineer intended " + "First let’s focus on handler onlightning input forReimbursed__c field " +
                    "Before we dive into handler let’s take step back glimpse on what lightning input has offer type= toggle really box toggle switch design apply CSS styling SLDS utilities messageToggleActive messageToggleInactive provide labels for ed un ed positions These handy attributes are several many others on lightning input Finallyonchange attribute lightning input gives us easy way wiretoggle switch action handler updatesrecord when slide right ed slide left un ed " +
                    "Now let’s think what happen when it’s ed un ed Based oncode we wrote expense updating expense probably something like " + "Getexpense item changed " +
                    " server action updateunderlying expense record " +
                    "Package expense intoaction " +
                    "Set up callback handleresponse " +
                    "Fireaction sendingrequest toserver " +
                    "Whenresponse comes andcallback updateexpenses attribute " +
                    "Um what expenses attribute Look at our markup again expenses just singular expense Hmmm right just single item There’s expenses attribute onexpensesList …but that’s component not even“real” expensesreal one attribute intop level expenses Hmmm " + "Is there get v parent would s get v parent get v parent —something would let us get reference our parent’s parent so we set expenses there " + "Stop Right There " + " do not reach into other set values on There’s way say “Hey grandparent I’m gonna update expenses ” keep their hands selves When wants ancestor make change something asks Nicely By sending event " + "Here’scool part Sending event looks almostsame handlingupdate directly Here’scode forclickReimbursed handler " + " " +
                    " clickReimbursed function event " +
                    " let expense = get v expense " +
                    " let updateEvent = getEvent updateExpense " +
                    " updateEvent setParams expense expense " +
                    " updateEvent fire " +


                    "Whoa That’s pretty simple does look kind like what we envisioned abovepreceding clickReimbursed doesfollowing " + "Getsexpense changed " +
                    "Creates event named updateExpense " +
                    "Packages expense intoevent " +
                    "Firesevent " +
                    " callback stuff missing but otherwise familiar But…what’s going handle callingserver andserver response updatemain expenses array attribute how do we know updateExpense event anyway " + "updateExpense event event we write ourselves beca unlike getting server action we getEvent instead get what we are getting doesn’t value provider just then name We’ll define event just moment " + "As what’s going handle callingserver handlingresponse let’s talk We could implementserver request handleresponse right here inexpenseItem we’d send event just rerender things depend onexpenses array would perfectly valid design choice would keepexpenseItem totally self contained desirable " + "However we’ll seecode creating expense andcode them updating existing expense are very similar enough so we’d prefer avoid duplicate Sodesign choice we’ve made send updateExpense event whichmain expenses handle Later when we refactor our form we’ll dosame creating expense " + "By child delegate responsibility handling server requests managingexpenses array attribute we’re breaking encapsulation bit But if think these child asinternal implementation details ofexpenses that’s OKmain expenses self contained " + "You choice consolidation critical logic encapsulation You’ll make trade offs Aura just like make trade offs any software design Just make sure documentdetails " + "Defining Event " +
                    " first thing we’ll do define our event select File | | Lightning Event nameevent “expensesItemUpdate” Replacedefault contents withfollowing markup " + " aura event type= " +
                    " aura attribute name= expense type= Expense__c " +
                    " aura event " +
                    "There are two types events application Here we’re using event beca we want ancestor handleevent ancestor “above” one in hierarchy If we wanted “general broadcast” kind event where any could receive we’d application event instead " + " full differences correct usage application vs events isn’t something we’re able get into here It’s advanced topic there are enough complicated details it’s distraction our purpose module When you’re ready moreResources help " + " other thing notice ab event how compactdefinition We namedevent when was created expensesItemUpdate its markup beginning ending aura event tag one aura attribute tag event’s attributes describepayload carry InclickReimbursed action handler we setpayload setParams Here inevent definition we see howevent parameter defined there are other valid parameters " + "And that’s pretty much there defining events don’t implementation behavior details events selves just packages fact events don’t any parameters at just messages “This happened ” ofbehavior what do if “this” happens defined in send receiveevent " + "Sending Event " +
                    "We already looked at how actually fire event inclickReimbursed action handler But work we do one last thing that’s registerevent line markup toexpenseItem right below its attribute definitions " + " aura registerEvent name= updateExpense type= c expensesItemUpdate " +
                    "This markup says our fires event named “updateExpense” type “c expensesItemUpdate” But wasn’t “expensesItemUpdate”name ofevent when we defined it what happened application event types " + "You’re right think it’s little confusing—it really bit switch roo might help think “application” “” Aura framework event types whiletypes come names events define are event types event structure types when define event define package format When register send event declare what format s " + " defining registering event might seem bit weird so let’s look ahead bit Here expenseItem we’re going send event named updateExpense Later expenseForm we’re going send event named createExpense Both these events include expense saved toserver so both c expensesItemUpdate event type package format send their events " + "Onreceiving end our main expenses going register handle both these events Althoughserver ends up beingsame r interface updates are slightly different So how does expenses know whether updateexpense inc expensesItemUpdate package Byname ofevent being sent " + "Understandingdistinction here how one event d multiple purposes light bulb moment learning Lightning If haven’t had moment quite yet you’ll when look atrest ofcode " + "Before we move on handling events let’s summarize what takes send " + "Define event by creating Lightning Event giving name attributes " +
                    "Register send these events by choosing event type giving specific type name " +
                    "Fireevent controller by " +
                    "Using getEvent specific event instance ";
    String text44 = "Sendingevent fire " +
            "If went ahead implemented ofcode we just app looked at Reload toggle Reimbursed box few s If missed step you’ll get error re work If did everything right…hey waitexpense changes color show its Reimbursed status just expected " + "This behavior was present we started unit That’seffect oflightning input value= v expense Reimbursed__c set When toggleswitchlocal version ofexpense updated But change isn’t being sent up toserver If look atexpense record Salesforce reloadwon’t seechange " + "Why not We’ve half ofwork complete circuit our event We finish wiringcircuit by creatingevent handler onother side event handler take care sendingchange toserver makingupdate durable " + "Handling Event " +
            "EnablingexpenseItem send event required three steps Enablingexpenses receive handle these events requires three parallel steps " + "Define event We’ve already beca expenseItem sendingsame event expenses receiving " +
            "Register handleevent mapsevent action handler " +
            "Actually handleevent action handler " +
            "Since we’ve already step let’s immediately turn step register expenses receive handleupdateExpense event Like registering send event registering handle one single line markup toexpenses right afterinit handler " + " aura handler name= updateExpense event= c expensesItemUpdate" +
            "Likeinit handler saura handler tag has action attribute setscontroller action handler forevent Like when registeredevent expenseItem here setname type ofevent—though note ofmuch sensibly named event attribute fortype " + "In other there’s not much here haven’t seen What’s specific handling events iscombination ofattributes knowing how receiver “socket” expenses matches up withsender “socket” expenseItem " + "This completeswiring part making work that’s left actually writeaction handler " + "We’ll start withhandleUpdateExpense action handler Here’scode sure put riiiiiight under action handler " + " handleUpdateExpense function event " +
            " let updatedExp = event getParam expense " +
            " updateExpense updatedExp " +

            "Huh That’s interesting Except forform validation andspecific function we’re delegatingwork looks like action handler issame handleCreateExpense " + "And now let’s addupdateExpense function we did withaction handler make sure put right belowcreateExpense function " + " updateExpense function expense " +
            " let action = get c saveExpense " +
            " action setParams " +
            " expense expense " +

            " action setCallback function response " +
            " let state = response getState " +
            " if state === SUCCESS " +
            " do nothing " +


            " $A enqueueAction action " +

            "Two things notice right offbat First except forcallback specificsupdateExpense identical tocreateExpense smells like opportunity " + "Second those callback specifics What gives How canright thing do nothing " + "Think moment Earlier when sendingevent if not we saw thatexpenseItem ’s color changed response togglingReimbursed box Rememberexplanation local ofexpense record already updated So at least formoment whenserver tells us was successful at updating its version we don’t do anything " + "Note handlescase whereserver successful at updatingexpense record We’d definitely work do if there was error Say Accounting flagged expense non reimbursable making impossible set field true But say lesson another day " + "RefactorHelper Functions " +
            "Let’s go back opportunity we saw factor common codetwo functions are identical except forcallback So let’s make generalized function takescallback parameter " + " saveExpense function expense callback " +
            " let action = get c saveExpense " +
            " action setParams " +
            " expense expense ";
    String text45 =
            " if callback " +
                    " action setCallback callback " +

                    " $A enqueueAction action " +

                    " callback parameter optional If it’s there we’ll pass along action Simple now we reduce our event specific functions tofollowing " + " createExpense function expense " +
                    " saveExpense expense function response " +
                    " let state = response getState " +
                    " if state === SUCCESS " +
                    " let expenses = get v expenses " +
                    " expenses push response getReturnValue " +
                    " set v expenses expenses " +


                    " updateExpense function expense " +
                    " saveExpense expense " +

                    "createExpense little shorter but it’s exclusively foc d on what do whenresponse comes backcallback wow updateExpense one liner " + "RefactorAdd Expense Form " +
                    "That little refactoring exercise was so satisfying using events was so we’re sorry electrifying let’s do again but bigger cowbell " + "This next task involves extractingAdd Expense form expenses moving its own Extractingform markup easy enough simple paste exercise But what moves it we start moving pieces around willy nilly let’s think what moves what stays " + "Incurrent designform’s action handler handles input validation sendingrequest toserver updating local state r interface sform action handler probably handle form validation But we’ll on rest stay behind beca we’re keeping our server request logic consolidated inexpenses " + "So there’s little but little teasing apart do there Our start by movingform markup move little possible after make work correctly We’ll refactor both communicate via events instead via direct access toexpenses array attribute " + "Let’s get started " + "Inmain expenses select everything betweentwo EXPENSE comments includingbeginning ending comments selves Cut clipboard Yes cut We’re committed " + " Aura name “expenseForm” Pastecopied Expense form markup intonew betweenaura tags " + "Back toexpenses Addnew expenseForm tomarkup section expenses look like " + " EXPENSE FORM " +
                    " lightning lay " +
                    " lightning lay Item padding= around small size= " +
                    " c expenseForm " +
                    " lightning lay Item " +
                    " lightning lay " +
                    "At reload seechanges There visible changes But unsurprisingly Expense button longer works " + "Let’s get throughrest ofmoving things around part " + "Next movenewExpense attribute expenses toexpenseForm markup d forform fields so needs inform moves over changes required so just cut one paste inother " + "InexpenseForm createcontroller resources " + "Move action handler expenses controller toexpenseForm controllerbutton inform soaction handler forbutton needs there too Believe not needs changes might begin sensing e here " + "Now we make couple actual changes But these familiar beca we’re just adding event sending we did expenseItem expenseItem you’ll recall sends event expense payload handled byexpenses " + "InexpenseForm createcreateExpense function " + " createExpense function newExpense ";
    String text46 = " let createEvent = getEvent createExpense " +
            " createEvent setParams expense newExpense " +
            " createEvent fire " +

            "This looks very much likeclickReimbursed action handler expenseItem " + "If going send event needs registerevent Addfollowing toexpenseForm markup just belownewExpense attribute " + " aura registerEvent name= createExpense type= c expensesItemUpdate " +
            "At we’ve work implementexpenseForm able reloadandform now “works” insense there are errors seeappropriate form messages when enter If you’re usingSalesforce Lightning Inspector see thatexpensesItemUpdate event being fired that’s left handle " + "Before we handleevent please do notice how easy refactoring was Most ofcode didn’t change There’s total six lines markup inpreceding steps It’s unfamiliar do work today but do few s realize you’re just moving bit around " + "OK let’s finish thisexpenseForm firescreateExpense event but we needexpenses First we registercreateExpense event handler wire tohandleCreateExpense action handler again single line markup line right above belowupdateExpense event handler " +
            " aura handler " +
            "Finally forlast step createhandleCreateExpense action handler inexpenses controller right above belowhandleUpdateExpense action handler " + " handleCreateExpense function event " +
            " let newExpense = event getParam expense " +
            " createExpense newExpense " +

            " together Yep simple ofwork delegated tocreateExpense function didn’t move change Our handleCreateExpense action handler just there wireright things " + "And we’re finished showing how loosely couple using events fireevent one handle another Wireless circuits " + "Bonus Lesson—Minor Visual Improvements " +
            "Before we head off intosunset challenge here modest visual improvement " + "We’d like improvelay our little bit by adding few container last bit gives opportunity seefull expenses after our changes Inexpenses replaceexpensesList markup withfollowing " + " lightning lay " +
            " lightning lay Item padding= around small size= " +
            " c expensesList expenses= v expenses " +
            " lightning lay Item " +
            " lightning lay Item padding= around small size= " +
            " Put something cool here " +
            " lightning lay Item ";
    String text47 = " lightning lay " +
            " effects ofchanges are margins padding makeexpenses narrowlay leaves room put something over there onright Innext unit we’ll suggest couple exercises could do on own " + "Resources " +
            "Communicating Events " +
            "Actions Events " +
            "Handling Events Client Side Controllers " +
            "Event Handling Base Lightning " +
            "Invoking Actions on Initialization " +
            "Detecting Changes " +
            " Events " +
            "Handling Events " +
            "Dynamically Showing Hiding Markup " +
            "Application Events " +
            "Handling Application Events " +
            "Event Handling Lifecycle " +
            "Advanced Events Example";
    String text48 = "Integrated withdatabase—It straightforward access manipulate records provides direct access records their fields provides statements query languages manipulate those records " +
            "Data foc d— provides transactional access todatabase owing roll back operations " +
            "Easy — based on familiar Java idioms " +
            "Easy test— provides built support unit creation execution Salesforce s works expected by executing unit prior any platform upgrades " +
            "Versioned— saved against different versions ofAPI " +
            " cloud based " +
            " Highlights " + "Like other oriented languages these are oflanguage constructs supports " + "Classes interfaces properties collections including arrays " +
            " array notation " +
            "Expressions variables constants " +
            "Conditional statements if control flow statements loops while loops " +
            "Unlike other oriented languages supports " + "Cloud development stored compiled executed incloud " +
            "Triggers are similar triggers systems " +
            "Database statements ow make direct calls query languages query " +
            "Transactions rollbacks " +
            " global access modifier permissive thanpublic modifier ows access across namespaces applications " +
            "Versioning custom ";
    String text49 = "We chase Virginia Woolf object Joyces Ulysses on its being prurient not beca contained such tropes ineluctable modality ofvisible while beca Joyce himself ref d alter single line his" +
            " short story Ivy Day inCommittee Room one poking fun at Prince Wales his publisher delayed publication than decade" +
            "To contemporary audience who access graphic pornographic imagery treasonable extremism few facile keystrokes such taboos appear absurd yet large part cultural ofth Century inWest at least was" +
            " taken up one battle after another asterritory deemed difficult was conquered renamed commonplace" +
            " problem atsame these victories were being won another province was being abandoned with fight isrealm where films paintings s newspaper articles radio television programmes are intellectually" +
            " dont moment mean suggest noone produces anymore cultural artefacts are difficult sense course do its just these works are longer regarded asdesiderata any wellcultivated person aspires to" +
            " appreciation difficult works are parcelled off andgreat plurality ubiquity our media means their specialist audience readily catered whether are foot fetishists Fourierists anything else"
            + " The suspicion mass media lead banal middlebrow culture old asprinting press arguably older given Plato writing was itself intolerable derogation ofpoetry ofspoken word But vantage" +
            " each successive wave crest popularisation anxieties preceding generations seem touchingly premature"
            + "Take cultural critic Dwight MacDonald who coinedexpression midcult refer those works pretend thought respectstandards high culture while fact water down vulgarize MacDonald was writing at" +
            " when novel American history " +
            "Aha say But was purely beca its titillating subject matter I would reply Quite possibly but along withpaedophilia Nabokov managed thrust into his readers tender lexicons many other difficult such as" +
            " grue heliotropic solipsism venus febriculosa often at rate than one page " +
            " coincidence these two kinds difficulty was I believe nothing ofkind attempting push forward intorealm deadening conformity artists writers ofth Century employed weapons there were hand" +
            " by making their works intellectually challenging deflectedaccusation their sexual violent content was there aro Recall defence against charge obscenity remains day work exhibit " +
            "genuine artistic merit" +
            "But now difficult subject matter if not exactly permitted readily accessible cultural artificers aim high displacement aesthetically intellectually difficult art aszenith has resulted " +
            "sorts sad interrelated phenomena" +
            "Inliterary world books intended child readers are repackaged sold kidult ones while notionally highbrow arbiters such Booker judges are obsessed by na ous confection jolly read Shakespeare remains our" +
            " national writer frankly bizarre given his recondite vocabulary myriad historical references convoluted metaphorical language were he seeking publication incurrent milieu his sonnets plays would undoubtedly branded too difficult fast culture at our peril unusual difficult art are us says Self" +
            "We are living riskaverse culture theres doubt that" +
            "Butrisk people seem most reluctant taking not physical but mental one just asconcrete childrens play has covered rubber sohard truth ab effort intellectual attainment being softened by sort semantic padding" +
            "Our arts humanities education at secondary level seems particularly afflicted by falling standards so much so universities are now being upon help write Alevel syllab s order cram our little chicks knowledge recent years has come seem unpalatable if not indigestible knowledge such English vocabulary beyond common usage" +
            "Both general readers specialist critics often complain my own English not my books but my newspaper articles radio talks such these I look up dictionary complain if were kind torture" +
            "In over twenty years publishing fiction journalism Ive become pretty much inured these slings arrows regarding par forantiintellectual course I d remonstrate those who raisedSword being sesquipedalian obscure word means lover obscure words" +
            "Id my texts were full resolutely AngloSaxon slang wereflowery andLatinate Id observe English being mishmash several different languages had large exciting vocabulary seemed shame not especially given went on growing spawning argot specialist terminology freely oyster does its milt";
    String text50 = "But has gone by Ive stopped bothering after one ofgreat things writing opposed other media makes claims on people unless engage no" +
            " matter how torturous don t leap books articles assault You go looking now I confine myself makingrueful althoughsubject matter my stories " +
            " s such phenomena sexual deviance drug addiction mental illness has become quite unexceptionablesupposedly difficult are couched seems become more" +
            " offensive readers Difficult iskey word here Inpast beforewithering away censorship wasdepiction sexuality andbodily general anything smacking antiauthoritarianism " +
            "that was perceived difficult visual artscurrent Damien Hirst retrospective at Tate Modern perfect opportunity see what becomes artificer whose impulse towards difficult subject matter was unsupported " +
            "by any capacity hard cogitation challenging artistryearly worksstuffed animals flybedizened carcasses retain certain albeit recherché shock value whilesubsequent ones degenerate steadily tocondition" +
            " knockedoff merchandise makingbarrier betweengift shop andexhibition space evaporate puff consumerism Butmost disturbing retreat difficult arts humanities " +
            "education wheretraditional set texts are now chopped up into boneless nuggets McKnowledge students are encouraged do their research such onweb place ofdifficulty involved seeking literary " +
            "canon younger people are coming rely on engines do their thinking end standardisation understanding itself people become unable think side ofboxshaped screennadir " +
            "came when my daughter who had assigned Great Expectations GCSE text was told s ending by her English teacher on readlittle gobbets served up interpretation according her " +
            "pedagogue there was necessity her try choke downwhole indigestible meal My figures food are entirely fitting beca we are danger becoming morbidly obese throughconsumption such fast culture The" +
            " contrast sport instructive both realms human endeavourconsumers are largely passive but at least sports fans unlike cultural ones dont protest against elite athletes bar competing on " +
            " are too fast too strong too limber Oncontrary we are repeatedly told bylikes Sebastian Coe athletes capable ofmost difficult feats offer vital inspiration couchpotato kids Letsame becase for";
    String text51 = " mental athletics beca with bar jump over set high well end up simply playing insandpit s readers are welleducated group expect sophisticated literate prose delight writing " +
            "and don’ t shy away complicated topics Onother hand probably don’ t carry unabridged dictionary along withnewspaper takesubway work don’ t expect news article posesame linguistic " +
            "challenge “ Finnegans Wake ” Our choice should ful precise we never talk down readers But how often s reader come across word like hagiography antediluvian peripatetic " +
            "especially breakfast One benefit readingTimes online is“ look up” function double on any word little question mark appears Clickquestion mark get definition Heritage " +
            "Dictionary My colleague James Robinsondirector Web analytics shared intriguing been with list good ofwords had looked up most often by s readers so year list few " +
            "words caution Don’ t takeprecise ranking numbers too literally Obviously how often word looked up depends partly on how much it’ d how many people are reading article online If Tom Friedman s " +
            "moderately unusual word say fealty I real headscratcher onsame day say it’ bet readers look up his word remember I’ m not trying ban these any challenging s " +
            " may perfectly justified But we keep mind why we’ re writing who’ reading under what circumstances we avoidtemptation display our erudition atreader’ expense said here’ slist " +
            " Check out few final comments I’ ll admit there were two onlist had thoroughly stumped sumptuary “ regulating expenses expenditures specif seeking regulate extravagance on " +
            "religious moral ” “ imaginary believed ca combustion given off by anything burning” Our handling “ ”though showed one way help readers tricky word" +
            " if don’ t look up was quote Science story physicists who work on Wall Street we gavebackground usingword But not so easy get ideas intoeconomic literature" +
            " many quants complain J Doyne Farmer physicist professor atSanta Fe Institute andfounder former chief scientist ofPrediction Company said he was shocked when he started reading finance literature at how " +
            "backward was comparing MiddleAges theories fire “ were talking — notright metaphor ” Dr Farmer said entries seem selfreferential it’ coincidence obscure difficult";
    String text52 =
            " abstr recondite not mention some solipsistic while many these look like foreign actually are sui generis bildungsroman my old friend schadenfreude make appearances " +
                    "some entries just seem baffling how did we end up using louche s Remember too striking very specific become wan devalued through over Consider apotheosis we’ somehow managed s so " +
                    "far year literally means “deification transformation into divinity ” extended meaning “ glorified ideal ” But our s seems suggest little than “ pretty example ” Most recently we’ " +
                    "ve said critics viewClinton healthcare “apotheosis liberal ofcontrol bureaucracybuilding ” we’ described cutoff shorts “ apotheosis laissezfaire wear ” So what do we say if someone really " +
                    "is transformed into god After Deadline examines questions grammar usage style encountered by writers editors ofTimes adapted weekly newsroom critique overseen by Philip B Corbettdeputy news editor" +
                    " who charge ’ style manual Ikinci Algoritmasi Herkese ileri Merhabalar Önceki yazılarımı okuyarak yazima geldiginizi umuyorum Boylece oyunun nasil oynandigini bildiginizi ilk algoritmasini incelediginizi" +
                    " varsayarak yazima devam edecegim okumadiysaniz konuya hakim ola acaginiz onceki yazilarimi okumanizi tavsiye ederim Ikinci Algoritmasi Uygun Hesaplama sonraki adimi attiktan sonra oyunun asamalarinda" +
                    " tur durumlarla karsilasabilecegini buna gore Sonraki adimda neler olacagini hesaplayip gore adim at a yonelik programlanmis algoritmadir Halk agziyla tabir edecek olursak cikmaz sokagi kestirip una gore " +
                    "veya geri adim atiyor Bundan sonra ilerlenebilecek uygun kareler cikmaz sokaga cikiyorsa karelere olumcul diyecegim algoritma kareye erisim saglanabilecek karelerin doldurulmasini engellemesi uzerine kodlanmistir" +
                    " Yani sayede kareye hic sekilde erisim ol acaksa o halde adim atarak gereksiz calismasin geri adim atsin mantigiyla calismaktadir Bunun cok basit islemi ekledim Islemi Algoritmanin " +
                    "ileri gerim adim atma islemine karar vermesi gerekiyor karari hesaplayacak fonksiyonun adina DeadlyPoint ismini verdim Boylece fonksiyon olumcul varsa geri adim atma komudu aksi halde adim atma komudu verecektir" +
                    " fonksiyonda degisken kullanilmaktadir Bunlar gidilebilecek yonler degiskenleridir kavrami demek Located gorselinde uygun kareler kirmizi cerceveli beyaz " +
                    "karelerde gosterilmistir Sol ustteki beyaz karenin uygun karenin kareye ilerlenilirse so ol acaktir Ancak kareye ilerlenilmedigi takdirde degiskende degisikli olusur Degisen degisken " +
                    "ise cikis degeridir Son atacagi belirlendigi da belirlenmis oluyor olarak belirlenen ilerlenilecek son olmalidir belirlendikten sonra tekrardan " +
                    " nin belirlenmesi soz konusu oldugunda geri kare adim atilmasi gerekmektedir Available Squares Available Squares gorselinde sol ust beyaz karenin Bunlardan tanesine adimda doldurulmus Digeri adimda" +
                    " doldurulmus Geriye kareye ulasilabilecek kaliyor O kareyi de adimda doldurulmus Burada algoritma yonlerin yonlerini hesaplar yonlerin yonlerini";
    String text53 =
            " kavrami demek adimin ilerleyebilecegi yonlerinden tanesinin hesaplanmis u bulunmus Onceden halini Forward available squares calculation gorselinde cizimlerle anlattim Neden hesapla i yapiyoruz Iki nedeni " +
                    "var Birinci nedeni Bulunulan adim icin var ilerlenebilecek yon kac tane tek Hesaplanilan islemimizde kullanicagiz Ikinci nedeni Sonraki adim ilerleyebilecek hesaplanirsa oyun bitmiyor o" +
                    " halde program geri adim atmasini saglayacagiz sayede verimsiz calis i ortadan kaldiracagiz yonlerden tanesine adim atildigi takdirde diger olarak belirlenmis olacaktir adimdan sonraki" +
                    " butun islemler gerceklestirildigini sayalim Tekrardan adima geri geldik sefer adim attigimiz kareyi olarak belirleyecegiz olarak belirledigimiz kareye adim atacagiz Tekrardan " +
                    "ilerisi islemler yapildigini varsayalim Tekradan adima geri geldik sefer her iki yonu olan kareye adim atilip hesaplamalar yapildigi artik geri adim atacagiz Forward One Way Number Located gorselleri " +
                    "ve aciklamalariyla farkli ozel durumu anlattim Artik iki kavramida bildigimize gore formulunu inceleyebiliriz Math Function taraf Adim atilmasi uygun olan karelerin tanesinin adim atabilecegi yonu " +
                    "oldugunun degeri alinir daha belirlenmis Exit Situation belirlenmemis Asagida takim ornekler verilmistir islemini yapabilmek her iki degiskeninde degeri" +
                    " bulunmaktadir verilen Eger Simdi bilgilere gore islemimizi yapalim belirsiz oldugunu varsayarak islem yapalim belirsiz islemimizin dogrulugunu " +
                    "Tek sayimiz olunca geri adim atmamiz gerekiyor Bunun yukarida incelemistik O halde yapilan islem dogru belirsiz belirsiz islemimizin Square dogrulugunu" +
                    " edelim sayimiz olunca yonlerden birisine ilerliyorduk Sonra tekrar geri adima gelince sefer diger yone ilerliyoruz Bunu yukarida incelemistik O halde yapilan islem dogru " +
                    "belirli sayisi olursa Matematik islemimizin dogrulugunu sayimiz olunca yonlerden birisinden ilerleyip diger yonu yapiyoruz burada farkli durum zaten " +
                    "belirlenmis tane olamaz yuzden geri adim atilmali O halde yapilan islem dogru Ilk algoritmasi olan oyun modlarinin rapo u inceledik Ikinci algoritmasi ayni oyun modlarinin rapo u cikardim";
    String text54 =
            " Iki rapo u da karsilastiralim Speed Comparison mode Speed Comparison far game Chart gorselini inceliyecegiz Tablonun her iki tarafinda lik oyunu modunun raporu Tablonun sol tarafi birinci algoritmasi" +
                    " hesaplanmistir Tablonun Solution tarafi ikinci algoritmasi hesaplanmistir Ikinci algoritma birinci algorit a gore lik oyun modunda kat daha kisa kisa surede cozmustur Milisaniye esas alinmistir kat daha while dongusune girmistir" +
                    " kat daha cozemeyecegi yonlere dogru adim atmistir karsilastir a bakarak sizce oyun modu kadar surede cozmustur Yaklasik olarak saat arasi mi vakit almistir sdersiniz Hadi lik oyun modu kiyaslama yapalim Speed Comparison " +
                    "Chart Speed Comparison gorselini inceleyelim onceki tabloda inceledigimiz gibi sol birinci algoritmasinin ikinci algoritmasinin rapo u icermektedir kat daha kisa surede cozmustur Saniye" +
                    " esas alinmistir kat daha while dongusune girmistir BUNUN BIRINCI ALGORITMAIN COZULMESI BEKLENIYOR kat daha cozemeyecegi yonlere dogru adim atmistir Coordinate Representation Coordinate Representation gorseli Each Squares " +
                    "Number gorselini Each Squares Number gorselini inceleyip her karede toplam sayisini gorebilirsiniz gorsellerden oyun modu hesaplanmis koordinat ni secip inceleyelim Coordinate Representation gorselinde " +
                    "gosterildigi uzere sol alt kareye ilk adim atildiktan sonra islemler gerceklestirilmistir Bulunulan toplam tanedir karenin her biri bunlar hesaplanmistir adet toplam koordinatlarda sekilde dagilmistir" +
                    " Each Squares Number Each Number Lik deneme likIkinci algoritmanin birinci algorit a gore cok daha hizli oldugunu kanitladik Peki hiz yeterince iyi olup olmadigini nasil edicegiz Bunun oyun modunu ust " +
                    "sayiya cikarip de ettim Malesef ve kareleri cozmesi bekleyemedim koordinattaki sayisini bulabildim lari inceleyelim milyon saatte cozdu Milyardan fazla while dongusune girdi Algoritma skor ala acagi halde halde" +
                    " adim atip sonra geri adim attigi zaman kaybi yasaniyor so u ortadan kaldirdigim vakit belkide saat oyun modundaki cozumleri bulabilecegim Aklimda algoritma takim fikirlerim Ancak universite " +
                    "ogrencisi oldugum derslerim sinavlarim cok vaktimi aliyor Yeterince odaklanamiyorum harika algoritmasi yazmak sabirsizlaniyorum Calcuate Minimum Different Squares Each Squares Number Each s" +
                    "Solution Number gorselinde seyin dikkatinizi cektigini umuyorum tane farkli karede de sayilardan olusuyor Calcuate Minimum need Different Squares gorselinde anlatildigi " +
                    "uzere aslinda tane karedeki sayilari hesaplanirsa moddaki toplam hesaplanabilir Mesela mavi rengideki karenin degeri hesaplandigini varsayalim karenin simetrileri olucak sekilde tane daha ayni cozumu " +
                    "sadece toplam sayisini bulmak istiyorsak karenin hesaplanmasi carpilmasi bize kat zaman kazandiracaktir Yani toplamda kareyi hesaplamak yerine karedeki cozumu hesaplamamiz yeterli olucaktir ";
}

