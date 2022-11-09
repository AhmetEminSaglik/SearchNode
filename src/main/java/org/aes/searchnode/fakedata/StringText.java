/*
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
            for (int i = 0; i < fieldList.size(); i++) {
                fieldList.get(i).trySetAccessible();
                textList.add((String) fieldList.get(i).get(this));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("textList : " + textList.size());


    }

<<<<<<< HEAD
=======
    String text0 = "testing tost3 tost3 tost3 tost3 tos ";
>>>>>>> parent of 504bff0 (NextWayDirectionTotalValue problem is fixed. Data ın current node ıs not calculated ın NWDTV, closed #8)

    String text1 = "Apex " +
            " testing frame triggers onLightning Platform high quality for let meet requirements deploying " +
            "Testing is key successful long term development critical of development frame easy code only written sandbox environment " +
            " Developer production deployed production org from sandbox as can distribute ers their to uploading packages Platform AppExchange addition being critical quality assurance requirements deploying distributing " + "These arebenefits " + "Ensuring triggers expected " +
            " Having suite regression every triggers updated future updates don’t break existing functionality " +
            "Meeting code requirements deploying production distributing via packages " +
            "High quality apps delivered toproduction production rs productive " +
            "High quality apps delivered package subscribers increase trust " +

            "Before major service upgrade behalf through of process called in current version and next release compare stest " +
            " that behavior hasn’t altered found result service upgradesHammer picks results selectively doesn’t Issues " +
            "triaged based certain criteria strives fix issues release ";
    String text2 =
            "Maintaining security highest priority dont view modify data is copy that secure center " +
                    "Code Requirement Deployment " +
                    "Before deploy package forLightning Platform AppExchange least must covered those must pass addition trigger must though" +
                    "code requirement deployment don’t meet requirement sure testcommon cases including positive negative cases bulk single processing " +
                    "Test Syntax " +
                    "Test defined annotation havefollowing syntax " +
                    " vo testName " +
                    " code_block " +

                    " annotation takes multiple modifiers parentheses separated blanks We’ll cover parameter later " +
                    " visibility doesn’t matter declaring public private doesn’t difference astesting frame al able access reasonaccess modifiers " +
                    "omitted insyntax " +
                    "Test must defined annotated sample shows definition ";
    String text3 =

            "private MyTestClass " +
                    " vo myTest " +
                    " code_block " +


                    "Test classes be either private or public ’re declare private Public typically factory covered later " +
                    "Unit Temperature " +
                    " simple three class example that’s being tested takes Fahrenheit input converts Celsius returnsconverted result" +
                    " Let’s add " +
                    "In File enter Temperature forclass OK " +
                    "Replacedefault body following " +
                    "public Temperature " +
                    " Takes Fahrenheit returnsCelsius equivalent " +
                    " public FahrenheitToCelsius " +
                    " Decimal " +
                    " setScale ";
    String text4 =
            "Press Ctrl+S save " +
                    "Repeatprevious steps Temperature Addfollowing " +

                    "private Temperature " +
                    " vo testWarmTemp " +
                    " celsius Temperature FahrenheitToCelsius " +
                    " vo testFreezingPoint " +
                    "Decimal celsius Temperature FahrenheitToCelsius " +
                    " vo testBoilingPoint " +
                    " celsius Temperature FahrenheitToCelsius " +
                    " vo testNegativeTemp " +
                    " celsius Temperature FahrenheitToCelsius ";
    String text5 =
            " Temperature test verifies thatmethod expected calling different fortemperature Fahrenheit verifies type input warm temperature" +
                    "freezing temperatureboiling negative temperatureverifications callingSystem takes parametersfirst isexpected value andsecond isactual value another version takes third parameter—a describescomparison being testBoilingPoint optional logged ifassertion fails " +
                    "Let’s " +
                    "In " +
                    "Under Temperature " +
                    "To test Temperature totest Selected " +

                    "In seestatus ning Expandtest expand again until seelist indiv ual were have green " +
                    " marks Inspect " +
                    " automatically generated triggers code percentage " +
                    " class ’ve tested Temperature has shown image " +
                    "View percentage " +

                    "Whenever modify refresh " +
                    "A known issue pr updating correctly ning subset update coverage use run rather " +
                    " than " + " would resulted full Temperature it’s still important ensure the" +
                    " quality Obviously isn’t possible every common points different ranges input passing " +
                    "positive negative numbers boundary values parameter values negative behavior for Temperature Converter common points the" +
                    " boiling negative temperatures " + " Temperature test doesn’t cover higher inval inputs boundary conditions Boundary conditions minimum " +
                    "and maximum values case temperature conversion accepts accept large numbers than Double values " +
                    " how at these butonly input does conversion handle value when variable evaluate" +
                    "formula throws NullPointerException modifyFahrenheitToCelsius input verify" +
                    " input behavior " + "Up pass conversion formula inclass correct that’s boring Let’s try simulate failure to" +
                    " see what happens fails let’s modifyboiling pass false expected value forboiling Celsius instead" +
                    " vo testBoilingPoint " +
                    " ca corresponding method fail " + "Change test Boiling Point to following " +
                    " celsius Temperature FahrenheitToCelsius " +
                    " Simulate failure " +
                    " celsius Boiling expected ";
    String text6 =
            "To execute same clicklatest Re assertion test BoilingPoint fails throws fatal error AssertException can’t caught " +
                    " results tab expandinglatest test reports four failed details ab failure double clicktest Detailed " +
                    "appear separate shown image Inspect failed " +
                    "To geterror fortest failure double ins eErrors column forfailed ’ll seefollowing descriptive text next Failed istext prov ed in" +
                    "System statement " + "System AssertException Failed Boiling expected Expected Actual " +
                    " numbers ’ll find innext " + "Increase " +
                    "Code " +
                    "When writing try achievehighest possible Don’t up just aim islowest thatLightning Platform requires deployments packages " +
                    " cases cover lihood robust Sometimes After " +
                    "common ca covering values conditional execution values tend ignored ca different branches to" +
                    " executed based whetherevaluated condition met different values " + " includesclass getTaskPriority contains" +
                    " two main task priority value based ongiven lead statemethod val atesstate first returns ifstate the" +
                    "state CAmethod returns High otherwise returns Normal other state value " + "public TaskUtil " +
                    " public getTaskPriority leadState " +
                    " Val ate input " +
                    " isBlank leadState leadState length " +


                    " taskPriority " +
                    " leadState " +
                    " taskPriority High " +

                    " taskPriority Normal " +

                    " taskPriority ";
    String text7 =
            " equality operator performs insensitive comparisons so there convert lower first means in" +
                    " satisfyequality condition literal " + " istest f etTaskPriority methodtest simply" +
                    " calls getTaskPriority state NY " +
                    "private TaskUtilTest " +
                    " vo testTaskPriority " +
                    " TaskUtil getTaskPriority NY " +
                    " Normal " +


                    "Let’s TaskUtilTest forcorresponding TaskUtil covers " +
                    "test finishescode TaskUtil shown open see six blue covered lines red uncovered lines shown image " + "Lines covered forTaskUtil " +
                    " reason why line wasn’t covered n’t contain pass state parameter Similarly line wasn’t covered " +
                    " n’t pass asstate Let’s cover those scenariosfollowing showsfull addingtestTaskHighPriority testTaskPriority classcode TaskUtil now " +
                    "private TaskUtilTest " +
                    " vo testTaskPriority " +
                    " TaskUtil getTaskPriority NY " +
                    " assertEquals assert Equals Normal ";
    String text8 = " vo testTaskHighPriority " +
            " TaskUtil getTaskPriority " +
            " High " +

            " vo testTaskPriority " +
            " TaskUtil getTaskPriority Montana " +
            " null " +


            "A collection every prepare deployment releases version define regularly " + " but now two aren’t let’s pretend formoment Assume want don’t want contains both execute " + "In select " +
            "Enter Temp TaskUtil OK ";
    String text9 = "Select TaskUtilTest hold downCtrl key select Temperature " +
            "To addselected editing window selected " +
            " Save " +
            "Select " +
            "Select Temp TaskUtil move Temp TaskUtil toSelected column " +

            "On monitorstatus ning Expandtest expand again until seelist indiv ual were indiv ual double names see detailed " +

            "Salesforce created aren’t committed todatabase rolled back whentest finishes execution rollback behavior handy don’t clean setup executes " + "By default don’t access pre existing except access metadata as Profile Creating robust pr failures ca missing changed directly ’ll find later " +
            " though best practice do needs access pre existing access annotatetest SeeAllDatatruetest don’t access therefore don’t SeeAllData parameter " +
            " save MB annotated don’t count toward limit " +
            " though rolls back separate unique constraints ing duplicate error ";
    String text10 = "Test don’t send emails " +
            "Test can’t call external services mock call " +
            " insert searches performed empty predictable setFixedSearchResults define returned bysearch " +
            "Resources " +
            " Gu Best Practices " +
            " Gu " +
            " Gu Isolation anization " +
            "Salesforce Help ing " +
            "Test Triggers " + "Learning ives " +
            " completing ll able " +
            " trigger fires single operation " +
            "Execute " +
            "Test Triggers " +
            "Before deploying trigger performactions firetrigger expected ";
    String text11 = "Let’s trigger ed Triggers module opportunitiesAccountDeletion trigger pr ’s deletion " + "Prerequisites " +
            "If haven’t yet addedAccountDeletiontrigger follow steps " +
            "In Console File Trigger " +
            "Enter AccountDeletion fortrigger select fors Submit " +
            "Replacedefault following " +
            "trigger AccountDeletion " +
            " Pr deletion accounts opportunities " +
            " [SELECT " +
            " WHERE SELECT Account Opportunity " +
            " Trigger old] " +
            " Trigger oldMap addError " +
            " opportunities ";
    String text12 = "If addedAccountDeletiontrigger previous disabled thatsystem could challenge re enable " +
            " Triggers " +
            "On Triggers page Edit next toAccountDeletion trigger " +
            "Select Active " +
            " Save " +
            "If contains triggers previous Add Call Trigger HelloWorldTrigger disable disableAdd trigger " +
            " Triggers " +
            "On Triggers page Edit next toAdd trigger " +
            "Deselect Active " +
            " Save " +
            "To disableHelloWorldTrigger Call Trigger triggers repeatprevious steps " +
            "Add " +
            "First let’s start adding method verifies trigger designed dopositive pr ing being opportunities " + "In File " +
            "Enter TestAccountDeletion forclass OK " +
            "Replacedefault body following " +
            " ";
    String text13 = "private TestAccountDeletion " +
            " vo Test Account Opportunity " +

            " an opportunity try " +
            " acct Test " +

            " Opportunity opp Opportunity + Opportunity " +
            " StageName Prospecting " +
            " CloseDate System today addMonths " +
            " Account " +
            " opp " +
            " Perform " +
            " startTest " +
            " Result false " +
            " stopTest Verify " +
            " casedeletion stopped bytrigger " +
            " got back error " +
            " isSuccess " +
            " getErrors size " +
            " Cannot opportunities " +
            " getErrors [0] get ";
    String text14 =
            " test first sets opportunity Next stest firesAccountDeletion triggertest verifies thattrigger pr eddeletion oftest ingreturn value ofDatabase callreturn value Result contains information ab operationtest verifies thatdeletion successful verifieserror obtained " +
                    "To methods " +
                    "Under TestAccountDeletion " +
                    "To inTestAccountDeletion totest Selected " +
                    " Findtest underlatest " +
                    " TestAccountDeletion contains single forpositive Al scenarios thattrigger cases including deleting opportunities bulk deletions " + "Test ins etest consuming many put creation callutility multiple next shows take advantage " +
                    " containsTest startTest stopTest pair delimits block gets fresh governor limits test beforetest performed governor limits isolate setup’s limit usage test’s isolatedata process’s limit usage enclosetest inTest startTest stopTest block block asynchronous information see Limits startTest stopTest " +
                    "A known issue pr updating correctly ning subset update than " + "Resources " +
                    " Gu Understanding " +
                    " Gu Triggers " +
                    "Learning ives " +
                    " completing ll able " +
                    " create " +
                    " various cases " +
                    "Execute " +

                    " reusable " + "Prerequisites " +
                    "Completeprerequisites inprevious Triggers haven’t already " + "Add ";
    String text15 = "Let’s refactorprevious replacing creation First createtest " + " TestDataFactory special type class—it public annotated accessed ning Test contain perform ful tasks setting excluded ’s limit " + "To addTestDataFactory " + "In File enter TestDataFactory forclass OK " +
            "Replacedefault body following " +

            "public TestDataFactory " +
            " public create Opps Integer num Integer numOppsPer " +

            " Integer i 0 i num i++ " +
            " TestAccount + i " +
            " add " +


            " Opportunity opps Opportunity " +
            " Integer j 0 j num j++ " +
            " [j] " +
            " ed opportunities " +
            " Integer k 0 k numOppsPer k++ " +
            " opps Opportunity + Opportunity + k " +
            " StageName Prospecting " +
            " CloseDate System today addMonths " +
            " Account " +


            " opportunities " +
            " opps " +
            " return " +


            " utility contains create Opps acceptsnumber held innum parameter andnumber opportunities held innumOppsPer parameterfirst loop inmethod createsspecified number stores variable first loop statement inlist indatabase " + " second loop createsopportunities group opportunities linked account er loop iterates contains nested loop creates opportunities forcurrent accountnext nested loop opportunities added tosame usingadd Opportunities linked their parent usingAccount fieldtotal number opportunities created isproduct ofnumber opportunities number numOppsPer num Next statement efficiently eloop opportunities incollection " + "Finally returns ofnew " + " ";
    String text16 = "Even though doesn’t return opportunities those writing ofexisting relationship between Opportunity as intrigger Triggers " + "Call Creation " +
            "Now ’ve addedtest modifytest take advantage InTestAccountDeletion replaceblock starts ends opp " +
            " opportunity calling " +
            " Account[] TestDataFactory create Opps " +
            " array returned byTestDataFactory create Opps contains " + "Here’smodified shorter version " +
            "private TestAccountDeletion " +
            " vo Test delete Account Opportunity " +

            " opportunity calling " +
            " Account[] TestDataFactory create Opps " +
            " Perform " +
            " startTest " +
            " Result [0] false " +
            " stopTest " +
            " thatdeletion stopped bytrigger " +
            " got back error " +

            " getErrors " +
            " opportunities ";
    String text17 = " getErrors [0] get " +


            "Test Conditions " +
            " enough possible fortrigger other conditions opportunities ame scenarios bulk number instead single Here updated version oftest containsthree additional Save updated version ofclass " +
            "private TestAccountDeletion " +
            " vo Test Account Opportunity " +

            " opportunity calling " +
            " Account[] TestDataFactory create Opps " +
            " Perform " +
            " startTest " +
            " Result [0] false " +
            " stopTest " +
            " thatdeletion stopped bytrigger " +
            " got back error " +

            " getErrors " +
            " opportunities " +
            " getErrors [0] get ";
    String text18 =
            " vo Test Account NoOpportunities " +

                    " opportunities calling " +
                    " Account[] TestDataFactory create Opps " +
                    " Perform " +
                    " startTest " +
                    " Result [0] false " +
                    " stopTest " +
                    " thatdeletion successful " +


                    " vo Test Bulk Opportunity ";
    String text19 =
            " opportunity calling " +
                    " Account[] TestDataFactory create Opps " +
                    " Perform " +
                    " startTest " +
                    " Result[] false " +
                    " stopTest " +

                    " casedeletion stopped bytrigger " +
                    " got back error " +
                    " Result dr " +
                    " dr " +
                    " dr getErrors " +
                    " opportunities " +
                    " dr getErrors [0] get ";
    String text20 = " vo Test Bulk NoOpportunities " +

            " opportunities calling " +
            " Account[] TestDataFactory create Opps " +
            " Perform " +
            " startTest " +
            " Result[] false " +
            " stopTest " +
            " thatdeletion successful " +
            " Result dr " +
            " dr " +


            " ";
    String text21 = " final step test our now thatclass contains comprehensive refactored factory Since ’ve already " +
            " inTestAccountDeletion its " + "To executesame click select " +
            " results expandinglatest test report four passed " +
            "Resources " +
            " Gu Common Creation" +
            "Get Started " + "Learning ives " +
            " completing ll able " +
            "Describekey features " +
            "Save Anonymous " +
            " inspect debug logs " +
            "Before Begin " +
            "Were excited accompany adventure module covers basic information enables ab also it language goes deep module first exposure highly recommend first go Quick Start project come back well waiting " +
            " Java syntax acts stored procedures business logic button clicks updates Visualforce pages " +
            "As " + "Hosted— saved compiled executed onserver— Platform " +
            " oriented— supports interfaces inheritance " +
            "Strongly typed— val ates references compile " +
            "Multitenant aware—Beca multitenant platform guards closely against a enforcing limits pr monopolizing shared resources ";

    String text22 = "In addition insensitive " + "Development ls " + " debug client computer usingSalesforce Extensions Visual Studio See Visual Studio Extensions " + " access debugging information directly inbrowser usingSalesforce interface Open under orquick access menu gear icon " + "Data Types Overview " +
            " supports various types including type Salesforce— type " +
            " supportsfollowing types " + "A primitive Integer Double Long Date Datetime String Boolean among others " +
            "An generic My __c ’ll learn later " +
            "A collection including " +
            "A array primitives defined created collections " +
            "A primitives defined created collections " +
            "A map primitive primitive collection " +
            "A typed values known enum " +
            " defined " +
            "System supplied " +
            " Collections " +
            "Lists hold ordered collection Lists synonymous arrays andtwo interchangeably " + " declarations equivalentcolors variable declared usingList syntax " + "List String colors String " +
            "Alternativelycolors variable declared array assigned than array " + "String[] colors String " +
            "Grow collections needed usingList square bracket array notation reference existing incollection index cant however bracket array notation " + " shows add " + " step " +
            "List String colors String red blue " +
            " created ";
    String text23 = "List String String " +
            "moreColors orange " +
            "moreColors purple " +
            "List read specifying index between brackets array read based onlists created inprevious shows read method shows iterate over array " +
            "String color1 " +
            "String color2 moreColors[0] " +
            "System color1 color2 " +
            " Iterate over read " +
            "for Integer i 0 i colors i++ " +
            " value todebug log " +
            " debug colors[i] " +


            "BeyondBasics " + " supports other collection types Map learn inCollections section Gu " +
            " ofbenefits re triggers other classesfollowing tutorial walks saving anization send emails inspecting debug logs " +
            "Save " +
            "SaveEmailManager anization " + "Open under orquick access menu gear icon " +
            "In File enter EmailManager forclass OK " +
            "Replacedefault body wiailManager " + " EmailManager public sendMail sends built Messaging library private inspectResults can’t externally private inclass inspectsresults ofemail send sendMail ";
    String text24 = "public EmailManager " +
            " Public " +
            " public vo sendMail String address String subject String body " +
            " mail " +
            " Messaging SingleEmail Messaging SingleEmail " +
            " String[] toAddresses String[] address " +
            " setToAddresses toAddresses " +
            " setSubject subject " +
            " setPlainTextBody body " +
            " Pass tobuilt sendEmail " +
            " ofMessaging " +
            " Messaging SendEmailResult[] Messaging sendEmail " +
            " Messaging SingleEmail [] " +
            " inspectreturned " +
            " inspectResults " +


            " private Boolean inspectResults Messaging SendEmailResult[] " +
            " Boolean sendResult true " +
            " sendEmail returns array " +
            " Iterate list inspect " +
            " class send ";
    String text25 = " if " +
            " Messaging SendEmailResult res " +
            " res " +
            " debug sent successfully " +


            " sendResult false " +
            " debugfollowing errors occurred + res getErrors " +


            " sendResult " +


            " File Save save " + " isn’t syntactically correct error shows inProblems error details correct " +

            "BeyondBasics " +
            " saved oriented OOPclass encapsulates managing perfect OOPclass would contain member variables accessor access those simplicity doesn’t " + "Salesforce compiles save " +
            "Call Send " + "Let’s invokepublic We’ll anonymous execution Anonymous ows lines onfly handy invoke especially functionality Debug log generated other execution " +
            "There other invoke triggers ’ll learn triggers another module " + "In Debug Open Anonymous Window " +
            "Inwindow opens enterfollowing Replace address address " +
            "EmailManager em EmailManager ";
    String text26 = "em sendMail address Trailhead Tutorial body " +
            " Now executed received inbox " +
            "Inspect Debug Logs " + "Debug logs ful debugging field name executecalls logged indebug log own debug tolog helps debugging errorsinspectResults sendMail tolog usingSystem debug indicate whetheremail send operation successful had errors indebug log generated executedmethod " + "In clickLogs double clickmost recent log inlist " +
            "Select Debug filterlog log lines debug shown Filterdebug log view debug " +
            " ’ll seefollowing infiltered log view assumingemail sent errors " + "DEBUG Email sent successfully " +
            "Also filterdebug log searching key inFilter selecting ofother options information seeLog Inspector help " +
            "Call " + "Beca sendMail doesn’t access member variables doesn’t instance Let’s change addingstatic key declaration easier than instance don’t instance ofclass directly onclass " + "In findopen forEmailManager modifyfirst line ofsendMail definition tofollowingonly change isadded statickey " +
            "public vo sendMail String address String subject String body " +
            " File Save save " +
            "Modify Anonymous window callstatic onclass " +
            "EmailManager sendMail address Trailhead Tutorial body " +
            " Now executed optionallydebug log inprevious steps ";
    String text27 = "Resources " +
            "Introduction ed Webinar " +
            " Gu Introducing " +
            "Trailhead Basics" +
            "Manipulate " + "Learning ives " +
            " completing ll able " +
            " update " +
            "Perform bulk " +
            " upsert update " +
            "Catch Exception " +
            " partial success option processresults " +
            "Know " +
            "Perform operations " +
            "Manipulate " +
            " modify usingData Manipulation abbreviated DML prov es straightforward manage prov ing simple update merge restore " + "Beca foc saved onLightning Platform direct access Un other languages require additional quickly connect sources managing made easy calling perform operations addsAcme created first passed argument to statement persists " +
            " Createaccount " +
            "Account Acme NumberOfEmployees 100 " +
            " account " +

            "DML " + " available " +
            "update ";
    String text28 = "upsert " +

            "un " +
            "merge " +
            "Each statement accepts single array Operating efficient processing " + "All in those except couple familiar operationsupsert merge into particular quite handy " + " upsert operation creates updates single statement specified each determinepresence existing or specified " + " merge statement merges three ofsame type of deletingothers re parenting " + " Auto Assigned " + "When ing ssystem assigns addition persisting value indatabase value auto populated ons variable argument inDML " + " shows get ons corresponds to ed " + " Createaccount " +
            "Account Acme NumberOfEmployees 100 " +
            " account " +

            " Getnew on ed argument " +

            " Display indebug log " +
            "System debug + " +
            " Debug log result " +
            " DEBUG D000000JmKkeIAF " +

            "BeyondBasics " + "Beca variable contains DML unit re variable perform further operations updates able maps variable matching " + " retrieve database obtain including can’t ’ll ’ll learn another " + "Bulk " + " perform operations single bulk Performing bulk operations isrecommended not helps avo hitting governor limits asDML limit per transaction limit place fair access shared resources inLightning Platform Performing operation counts statement statement " + " bulk ing callsample updates those bulk " + "Execute snippet Anonymous " +

            "List conList " +
            " FirstName Joe LastName Smith Department Finance " +
            " FirstName Kathy Smith Department Technology " +
            " FirstName Caroline Roth Department Finance " +
            " FirstName Kim Shain Department Education " +
            " Bulk " +
            " conList " +
            " holdnew update " +
            "List listToUpdate " +
            " Iterate list title " +
            " ifdepartment Finance " +
            "for con conList " +
            " con Department Finance " +
            " con Title Financial analyst " +
            " updated tolist " +
            " listToUpdate con ";
    String text29 =

            " Bulk update " +
                    "update listToUpdate " +
                    "Inspect recently created " + "Two of who inFinance department their titles populated Financial analyst " +
                    "Upsert " + "If containing mix existing ions updates inlist usingupsert statement Upsert helps avo creation duplicate save don’t determine exist first " + " upsert statement matchess existing comparing values don’t specify calling statementupsert statement ss ’s matchs existing Alternatively specify matching specify marked external standard specify has up property true Email has up property field’s property see Reference Platform " + "Upsert Syntax " + "upsert [] " + "upsert [] " + " optional field token specifyMyExternal fieldstatement " +
                    "upsert List fields MyExternal " +
                    "Upsert ss primary key up external determine whether update existing " + "Ifkey matched created " +
                    "Ifkey matched onceexisting updated " +
                    "Ifkey matched multiple error generated and neither ed updated " +
                    " shows upsert updates existing upsert updatesexisting Josh Kathy " +
                    " upsert matchfirst contactjosh variable being re forupsert variable already populated previous so doesn’t explicitly " + "Execute snippet inExecute Anonymous window " +
                    " Josh " +
                    "Contact josh FirstName Josh Kaplan Department Finance " +
                    " josh " +
                    " Joshs ed " +
                    " sovariable josh now " +
                    " match upsert " +
                    "josh Description Josh updated byupsert operation " +
                    " CreateKathy dont persist indatabase " +
                    "Contact kathy FirstName Kathy Brown Department Technology " +
                    " holdnew upsert " +
                    "List josh kathy " +
                    " upsert " +
                    "upsert " +
                    " Josh updated Kathy created " +
                    "Inspect " + " Josh Kaplan upsert operation foundexisting updated instead creating Kathy Brown " +
                    "Alternatively specify matching sEmail up property sJane Smith creates second populates same calls upsert updatecontact usingemail matching " + " ";
    String text30 = "If instead upsert duplicate Jane Smith would ed " + "Execute snippet inExecute Anonymous window " +
            "Contact jane FirstName Jane " +
            " Smith " +
            " Email jane smith@ com " +
            " Description ofday " +
            " jane " +
            " Upsert up " +
            " second variable " +
            " variable doesn’t " +
            "Contact jane2 FirstName Jane " +
            " Smith " +
            " Email jane smith@ com " +
            " Description Prefers contacted " +
            " Upsertcontact using up matching " +
            "upsert jane2 " +
            " thatcontact updated " +
            "System Prefers contacted " +
            " [SELECT Description WHERE jane ] Description " +
            "Inspect " + " Jane Smith updated description " +
            " persisted using statement aren’t permanently Platform placed inRecycle Bin days where restored " + " shows whose last Smith ’ve sample bulk already last Smith snippet Anonymous last Smith anymore " + "Contact[] Del [SELECT WHERE Smith] " +
            " Del " +

            " snippet lightning retrieve ’ll learn another " + "DML Statement Exceptions " + "If operation fails returns exception type DmlException exceptions error conditions " + " produces DmlException attempts required fieldexception caught incatch block " + "try " +
            " exception ";
    String text31 = "required prov ed " +

            " account " +

            " DmlException " +
            " debug exception occurred + " +
            " get " +

            "Database " +
            " containsbuilt prov es perform operations mirrorDML statement counterparts " +
            "These are onclass " + "Database " +
            "Database update " +
            "Database upsert " +
            "Database " +
            "Database un " +
            "Database merge " +
            "Un optional OrN parameter ows specify whetheroperation partially succeed parameter false errors occur partial ssuccessful committed errors returned forfailed exceptions thrown partial success option " + " call allOrN false " + "Database List false " +
            " containing success failure information update operations array SaveResult " + "Database SaveResult[] List false " +

            "Upsert returns UpsertResult returns Result " + "By defaultallOrN parameter true means thatDatabase behaves statement counterpart throw exception failure encountered " + " equivalent to List statement " + "Database List " +
            "And " + "Database List true " +

            "BeyondBasics " + "In addition Database contains aren’t prov ed transaction control rollback emptyingRecycle Bin queries ’ll learn another " + " Partial Success " + "Let’s take sDatabase based onbulk replacesDML statement methodDatabase partial success option inlist doesn’t purpose ca error can’t saved required Three committed andcontact generates errorlast part iterates returned debug todebug log " + "Execute inExecute Anonymous window " +

            "List conList " +
            " FirstName Joe Smith Department Finance " +
            " FirstName Kathy Smith Department Technology " +
            " FirstName Caroline Roth Department Finance " +

            " Bulk " +
            "Database SaveResult[] srList conList false " +
            " Iterate returned ";
    String text32 = "for SaveResult sr srList " +
            " sr " +
            " Operation successful get of processed " +
            " debug Successfully ed Contact + sr get " +

            " Operation failed errors " +
            " Error err sr getErrors " +
            " debugfollowing error occurred " +
            " debug err getStatusCode + + err get " +
            " debug affected error + err getFields " +
            "\t " +


            "Verifydebug DEBUG key forfilter " + " failure reported three ed " +
            "Should " + " want error occurs during bulk processing thrown exception immediately interrupts control flow try blocks behavior similar to exceptions most procedural languages " +
            " want ow partial success bulk operation—if failsremainder ofDML operation succeed application inspect rejected possibly retryoperation form never throws exception errors Instead appropriate array judge success failure include syntax supports thrown exceptions similar " +

            " manage other relationships " + " existing relationship already defined betweentwo up master detail relationship associated foreign key ing specify settingvalue ofAccount " + " shows account settingAccount oncontact linked up relationship " + "Execute snippet inAnonymous window " +
            "Account SFDC " +

            " Once eds " +
            " populated " +


            " ";
    String text33 = "Contact mario " +
            " FirstName Mario " +
            " Ruiz " +
            " 415 " +
            " Account " +
            " mario " +
            "Inspect " + "A SFDC created hasMario Ruiz inaccount’s " +
            "Update " + "Fields cant updated same toDML operation require separate ing specify settingvalue ofAccount However cant change updatingaccount itself separate Similarly updating want updatecontact’s must callsfollowing updates update " +
            " forcontact associated " +
            "Contact queriedContact [SELECT " +

            " WHERE FirstName Mario Ruiz " +
            " LIMIT ] " +
            " Update number " +
            "queriedContact " +
            " Update industry " +
            "queriedContact Industry Technology " +
            " separate calls " +
            " update " +
            "update queriedContact " +
            " update Industry " +
            "update queriedContact " +
            " operation supports cascading deletions parent children automatically long child " + "For deletingaccount Salesforce created earlier SFDC " + "Execute snippet inAnonymous window " +
            "Account[] queried [SELECT WHERE SFDC Account] " +
            " queried " +
            " ’ll see bothaccount were " +
            "Ab Transactions " + "DML operations transaction operations transaction complete successfully error occurs operati ntire transaction rolled back committed todatabaseboundary transaction trigger anonymous block page Web service trigger creates updates andcontact update fails val ation rule failureentire transaction rolls back n of persisted " + "Resources ";
    String text34 = " Gu " +
            " Gu ing " +
            " Gu Adding Retrieving " +
            " Gu Class" +
            " Queries " + "Learning ives " +
            " completing ll able " +
            " queries " +
            "Execute queries using Editor " +
            "Execute queries embedded Anonymous " +

            "Get Started " +
            "To read must prov esSalesforce short read saved similar tostandard SQL ized forLightning Platform " + "Beca direct access stored indatabase embed queries straightforward fashion embedded referred inline " + "To include queries wrap statement brackets assignreturn value array following retrieves returns array " +
            "Account[] [SELECT Account] " +
            "Prerequisites " + "Some queries expect queries sample " + "In openExecute Anonymous window Debug menu " +
            " below snippet inwindow " +
            " ";
    String text35 = "Account " +
            " SFDC Computing " +

            " NumberOfEmployees 50 " +
            " BillingCity San Francisco " +

            " Onceaccount eds " +
            " populated " +


            "Contact con " +
            " FirstName Carol " +
            " Ruiz " +

            " Department Wingo " +
            " Account " +
            " con " +

            "Account 2 " +
            " SFDC Man " +

            " NumberOfEmployees 50 " +
            " BillingCity Los Angeles " +
            " Description Expert wing technologies " +
            " 2 " +
            " Editor " + " prov es Editor queries view results Editor prov es quick inspectdatabase queries adding Editor must supply only statement surrounds " + "Let’s try ningfollowing " + "In click Editor " +
            "Copy pastefollowing first box under Editor " +
            "SELECT " +
            "All appear section rows " + "Basic Syntax " +
            " issyntax basic " + "SELECT [WHERE Condition] " +
            " WHERE cla optional Let’s start very simple following retrieves gets " + "SELECT " +
            " parts " + "SELECT part listsfields would retrievefields specified SELECT key comma delimited specify comma necessary g SELECT " +
            " part specifiesstandard want retrieve it’s Invoice_Statement Invoice_Statement__c " +
            " ";
    String text36 =
            "BeyondBasics " + "Un other SQL languages can’t specify must specify every want explicitly try access haven’t specified inSELECT cla ’ll error hasn’t retrieved " + " don’t specify al returned queries whether specified SELECT SELECT equivalent only want specify isonly ’re retrieving least SELECT want specify ning Editor as won’t displayed unless specified " + "Filter Conditions " + "If than returned want limit returned fulfill certain condition condition ins eWHERE cla following retrieves only whose names SFDC Computing comparisons insensitive " + "SELECT WHERE SFDC Computing " +
                    " WHERE cla contain multiple conditions grouped logical operators parentheses returns whose SFDC Computing than employees " + "SELECT WHERE Name=SFDC Computing NumberOfEmployees " +
                    " another complex condition returns " + "All SFDC Computing " +
                    "All than employees whose billing city Los Angeles " +
                    "SELECT WHERE SFDC Computing NumberOfEmployees BillingCity Los Angeles " +

                    "BeyondBasics " + "Instead usingequal operator comparison perform any fuzzy matches using operator retrieve whose names start SFDC condition WHERE SFDC wildcard character matches character_ character contrast match character " + "Order " + "When executes returns particular order can’t rely onorder inreturned array besame however choose sortreturned adding ORDER cla specifyingfield which sorted sorts retrieved based onName " + "SELECT ORDER " +
                    " default sort order al abetical order specified ASCprevious statement equivalent " + "SELECT ORDER ASC " +
                    "To reverseorder DESC key descending order " + "SELECT ORDER DESC " +
                    " sort most including numeric text can’t sort rich text multi select picklists " + "Try Editor see ho er ofreturned changes based onName " + "LimitNumber Returned " + " limitnumber returned arbitrary number addingLIMIT n cla where n isnumber want returned Limitingresult handy don’t care returned want subset retrievesfirst returned Notice thatreturned value array LIMIT " + "Account AccountOnly [SELECT LIMIT ] " +
                    "Combine Pieces " +
                    " combineoptional cla infollowing order " + "SELECT " +
                    " WHERE SFDC Computing NumberOfEmployees " +
                    " ORDER " +
                    " LIMIT " +
                    "Executefollowing usingExecute Anonymous window inspectdebug indebug log sample returned " + "Account[] [SELECT " +
                    " WHERE SFDC Computing NumberOfEmployees " +
                    " ORDER " +
                    " LIMIT ] ";
    String text37 =
            "System debug + returned " +
                    " array info " +
                    "System debug " +
                    "Access Variables Queries " + " reference variables expressions preceded colon local variable statement bind " + " shows targetDepartment variable inWHERE cla " + " targetDepartment Wingo " +
                    "Contact[] tech [SELECT FirstName " +
                    " WHERE Department targetDepartment] " +
                    " linked other relationships up relationships master detail relationships up relationship update associate account associated same appear onaccount’s page Insame view inSalesforce interface " + "To child parent inner forchild cla ofinner againstrelationship than contains inner associated returned account cla specifies relationship default relationship links " + "SELECT SELECT WHERE SFDC Computing " +
                    " next embeds shows getchild using relationship ons " + "Account[] [SELECT SELECT FirstName " +

                    " WHERE SFDC Computing] " +
                    " child " +
                    "Contact[] cts [0] " +
                    "System debug first associated " +
                    " + cts[0] FirstName + + cts[0] " +
                    " traverse relationship child parent dot notation following snippet queries whose first Carol able retrievename Carol’s associated traversingrelationship between " + "Contact[] cts [SELECT " +
                    " WHERE FirstName Carol Ruiz] " +
                    "Contact carol cts[0] " +
                    " Name carol " +
                    "System debug Carol\\s + Name " +

                    " section based standard linked relationships relationship names end __r suffix invoice linked line items Line_Items__r relationship onInvoice_Statement__c " + " Batches Loops " + " loop include loopresults iterated over inloop loops retrieving s— retrieved efficient chunking calls to More ofSOAP API loops avo hittingheap limit " + " loops iterate over ofs returned syntax loop " +
                    "for variable [ _ ] " +
                    " code_block " +

                    "or " +
                    "for variable_list [ _ ] " +
                    " code_block ";
    String text38 =

            "Both variable variable_list must ofsame type ass returned by _ " + "It preferable format of loop asloop executes batch Doing batches perform operations batch helps avo reaching governor limits " + " Account[]new loop " +
                    " loop " +
                    " loop " +
                    "s format executesfor loop per returned batch " +

                    "Integer i 0 " +
                    "Integer j 0 " +
                    "for Account[] tmp [SELECT WHERE loop _] " +
                    " j tmp " +
                    " i++ " +

                    "System jlist containedthree " +
                    " named yyy " +
                    "System i Since single batch hold " +
                    " three returned" +
                    " loop executed " +
                    "Resources " +
                    " SOSL Reference" +
                    " Queries " + "Learning ives " +
                    " completing ll able " +
                    "Describedifferences between " +
                    "Search across multiple queries " +
                    "Execute queries using Editor " +
                    "Get Started " +
                    "Salesforce contacts perform text searches across multiple standard similar Apache Lucene " + "Adding queries simple— embed queries directly embedded referred inline " + " searches SFDC " +
                    "List searchList [FIND SFDC " +
                    " RETURNING FirstName ] " +
                    "Differences Similarities Between " + " ows anization’s information Un standard single " + "Another difference matches based match performs exact match default wildcards searching Digital returns whose values Digital orDigital Company returns values Digital " + " separate languages different syntax distinct " + " retrieve single " +
                    " across multiple queries most text " +
                    "Prerequisites " + "Some queries expect haven’t createdsample sample Otherwise skip creatingsample section " + "In openExecute Anonymous window Debug menu " +
                    " below snippet inwindow " +

                    "Account " +
                    " SFDC Computing " +

                    " NumberOfEmployees 50 " +
                    " BillingCity San Francisco " +

                    " Onceaccount eds " +
                    " populated " +


                    "Contact con " +
                    " FirstName Carol " +
                    " Ruiz " +

                    " Department Wingo " +
                    " Account " +
                    " con " +

                    "Account 2 " +
                    " SFDC Man " +

                    " NumberOfEmployees 50 " +
                    " BillingCity Los Angeles " +
                    " Description Expert wing technologies " +
                    " 2 ";
    String text39 =
            " Editor " + " prov es Editor queries view results Editor prov es quick inspectdatabase queries adding Editor supply only statement surrounds " + "Let’s try ningfollowing " + "In click Editor " +
                    "Copy pastefollowing first box under Editor " +
                    "FIND Wingo RETURNING FirstName Department " +
                    "All satisfycriteria display section rows fieldsresults grouped tabs contact returns whose values match Wingo Based sample value Wingo returned " +
                    " Editor andAPI must enclosed curly brackets Wingo contrast enclosed single quotes Wingo " + "Basic Syntax " +
                    " ows specifyfollowing criteria " +
                    "Text expression single rase " +
                    "Scope " +
                    "List retrieve " +
                    "Conditions selecting rows insource " +
                    " issyntax basic " + "FIND Search [IN SearchGroup] [RETURNING sAndFields] " +
                    "Remember Editor APIsyntax slightly different " + "FIND Search [IN SearchGroup] [RETURNING sAndFields] " +
                    "Search istext single rase terms grouped logical operators parentheses terms include wildcard characters wildcard matches zero characters atm dle end ofsearch term wildcard matches character atm dle end ofsearch term " + "Text searches insensitive searching er er ER returnsame " + "SearchGroup optional isscope offields specifieddefault scope SearchGroup take offollowing values " + "ALL " +
                    "NAME " +
                    "EMAIL " +

                    "S EBAR " +
                    " sAndFields optional isinformation insearch result—a optional values filter against specifiedsearch contain " + "Single rases " + "A Search contains types text " + "Single — single hello inSearch delimited spaces punctuation changes letters digits vice versa al insensitive " +
                    " rase— collection spaces surrounded double quotes john smith Multiple combined logic grouping operators form complex ";
    String text40 = "Search " + "To learn let’s play different see put based sample table lists various and " + "Search \tSearch Description\tMatched " +
            " \t returns whose contain both sand location oftextorder insearch term doesn’t matter \t FDC Man matched " +
            "Wingo Man\t sOR logical operator returns containing Wingo containing Man \tContact Carol Ruiz Department Wingo " +
            " FDC Man matched " + "1212\t returns whose contain end matched cons ered delimited bydash \t FDC Man " +
            "Contact Carol Ruiz " + "wing\t wildcard returns value starting wing \tContact Maria Ruiz Department Wingo " +
            " FDC Man Description Expert wing technologies " +
            " shows Firstvariable FindCla assignedsearch consists terms Wingo SFDC combined byOR logical operator references local variable preceding colon bindingresulting searches Wingo SFDC returns sample containing of returned lists contains array ofreturned caselist index containsarray index containsarray " + "Execute snippet inExecute Anonymous window Next inspectdebug log returned " + " FindCla Wingo SFDC " +
            "List searchList [FIND FindCla " +
            " RETURNING FirstName Department ] " +
            "Account[] search Account[] searchList[0] " +
            "Contact[] search Contact[] searchList[1] " +
            "System debug Foundfollowing " +
            "for search " +
            " debug " +

            "System debug Foundfollowing " +
            "for c search " +
            " debug c + + c FirstName " +

            " Me More " +
            " filter reorder limitreturned queries multiple those filters applied ins eRETURNING cla " + " filter adding conditions inWHERE cla whose industry Apparel returned RETURNING Industry WHERE Industry Apparel " + " wise ordering supported adding ORDER ca sreturned ordered byName RETURNING Industry ORDER " + " number returned limited subset limitsreturned RETURNING Industry LIMIT " + "Resources " +
            " SOQL Reference" +
            " Actions Controllers " +
            "Learning ives ";
    String text41 =
            " completing ’ll able " +
                    " client actions " +
                    "Read values " +
                    "Read values interface controls " +
                    " JavaScript changes interface " +
                    "Handling Actions Controllers " +
                    "Up now we’ve ed XML style markup nowonly ’s put change change markup now n’t react input now haven’t written JavaScript " + "That changes " + "To started let’s very simple imagine needs able simple behavior " + " ofday nice today button Today going great day button " +
                    " hello Interactive it’s hard imagine simpler “does something ” It’s bit text currently blank buttons Here’scode " + " aura " +
                    " aura type String " +
                    " p ofday p " +
                    " div " + " familiar we’ve really added button hello button ofday updated " + "Well quite yet ’ve already enteredcode tried rself ’ve noticed ofbuttons error " + "There problem " +
                    "We’ll befirst admit every error ’ll see helpful might hope says there’s controller" +
                    " named “ Click” Where does “ Click” come comes expression assigned n oftwo button tags " + "Given button probably guess thaton assign behavior tobutton it’s clicked assigned expression c that’s be bit mysterious " + "It’s actually pretty simple expression earlier c value prov er c property c isvalue prov er for’s client defined c reference in’s " + "c c value prov er for property defined " +
                    "Uh ’s " +
                    "Whoops basically collection defines app’s behavior “things happen ” whereby “things” mean input other updates “Model View Controller” number sites ’ll various definitions purposes resource bundle holdsaction JavaScript functions particular signature " + "BeyondBasics " +
                    " talk lot controllers know that itself view menti dMVC Model View design pattern that’s common web frame built onMVC pattern " + "In similarities sure would correct say View Controller Model perhaps View Controller Database " + "Why “controller” doubled pattern interacting server addition toclient we’ve ed dual design iskey difference between MVC " + " ’sdistinction between “model” “database” traditional MVCmodel programmatic abstraction usually betweenunderlying storage usually relational andrest ofapplication there’s directly stands between @AuraEnabled operations again already abstraction between andunderlying storage layer calculation val ation logic fully programmatic behavior inform triggers model say po TAY tow it’s totally cool want go po TAH tow " + "Conf Excited We’ll sorted ondetails server controllers later " + "Let’s athello Interactive detail explanation bit concrete " +

                    " let btnClicked getSourcebutton " +
                    " let btn btnClicked labelbuttons label " +
                    " btn update ";
    String text42 =
            "Controller resources interesting format JavaScript contain map value pairs wherename isname ofaction andvalue definition " + "Action " +
                    " combination value pair signature ’ll hear seeterms interchangeably formost part that’s correct almost al refer tosame thing We’re going worry ab exceptions module " + "Don’t worry much ab special format ofcontroller resource clickCONTROLLER button ’ll resource already added trick is—and syntax errors f et— put commas between basic JavaScript syntax we’ll see bit " + " actual four lines might seem hard understand first high level it’s simple Whenbutton clicked gets Inaction controller getsbutton clicked pullslabel text sets’s text And ofday updated Today going great day " + "Inaction controller getsclicked button text sets " +
                    "Simple right Well… " + "Beca super important let’s break down line line " +
                    " followed anonymous declarationimportant thing here isfunction signature it’s technically required al declare functions take three parameters We’ll talk go now parameters represent " + "— it’s hello Interactive " +
                    " — ca daction " +
                    "helper— ’s another JavaScript resource reusable functions " +
                    " let btnClicked getSourcebutton " +
                    "Remember connected button tag some clickingbutton Ins hasnotion sourcething generated isbutton itself calling getSource gets us reference to button clicked " + " let btn btnClicked labelbuttons label " +
                    " do now reference tobutton ins label onlightning button markup button label nice today " + "Let’s think bit don’t havedefinition button front us label another much added hello Interactive prov ename of want retrieve informat Nameresult is value " + " markup representsview itself—but it’slightning button child hello Interactive Think btnClicked label taps onshoulder ever btnClicked says “Hey give label” thinks “v ” ins itself returnsvalue label " + "So now text retrieved button step left change t w text Unsurprisingly reads value value " + " btn update " +
                    "However let’s notice important difference btnClickedlightning button that’s ins hello Interactive We’re calling — hello Interactive itself pattern ’ll repeat virtually every values child be processing values itself " + " Aura View Model " +
                    "OK gut making sense sure think sure ’ve actually createdhello Interactive usingpreceding It’s pastingcode takes minutes being able play essential understanding handling actions " + " ’ve here might seem very simple it’s very many lines lines illustrate offundamental concepts building apps Aura " + " think hooking “wiring ” Think hello Interactive simple electrical circuit switches light bulbsLightning frame suppliespower itself switch might nice clicking sound until wire it’s very functional havetrendiest Edison style light bulb until wire doesn’t illuminate anything " + "And Aura back ago sa thatdifferent resources bundle “auto wired” other that’s truewiring takesform ofv c value prov ers automatically created made available reference vice versa auto wiring takes place high level—in hello Interactive between cmp resource andcontroller js resource isgreen arrow infollowing illustration " + "hello Interactive auto wired " +
                    " wiring hook button —that wiring things generate buttons tothings function—that’s wiring rself fact rself arered arrows complete ing circuit " + "Adding c n button wires to Calling new wires upresult to’s itself wired expression " + " further think ofon electron flowing alongcircuit ’ve created haven’t created complete circuit doesn’t go anywhere nothing happens start writing own keep mind complete circuit sure doubt sometimes helps sketch whiteboard paper confirm every connection " + " ’ll wire low high levels often ’ll feel electrician givenname offrame be Ben Franklin Wiring things fundamental toAura model " + "So let’s practice perfect " + "Function Chaining Rewiring Simple Debugging " +
                    "Our first version three lines broke step inget pattern separate lines something chaining collapse those fewer lines Since ’ll probably see other let’s give whirl ourselves Addfollowing additional hello Interactive " + " Click2 " +
                    " let new getSource label " +
                    " new " +

                    " Click3 " +
                    " getSource label " +

                    "Whoopsie syntax error trying save Remember earlier sa commas between That’sissue here comma final brace “ ” see atend Click2 inpreceding snippet " + "These exactlysame thing fewer lines skipping intermediate variables often “chaining” directly t xt adding toend ofprevious separated period concept most clear ing atdifferences between Click2 " + "Which style prefer matter personal taste perhaps anization’s coding style humble author prefers Click2 separatingget bothering variable forbutton label text " + "Of course can’t thatnew until wire button settingon c Click2 c Click3 Think disconnectingwires light bulb attaching light bulb It’s easy " + "At reload ofrewired buttons and…well it’ssame design isn’t it being " + "Sometimes simple best Let’s bit logging ofaction functions " + " Click2 " +
                    " let new getSource label " +
                    " log Click2 + new " +
                    " new " +

                    "Now wire button Click2 ’ll see log browser’s JavaScript whenever " + "Yes so isticated debugging ls printing things toconsole honored debugging technique want put sort wrap JSON ify ful details ’re quick peek log friend " + " won’t cover those so isticated debugging ls techniques here see Resources great ls instructions " + "OK hello Interactive stup simple hard coded relentlessly positive attitude Innext we’ll something complex learn capture real input since people inreal world aren’t al positive we’ll learn val ate their input " + "Resources " +
                    " ing Base " +
                    " Handling Base " +
                    "lightning button Documentation " +
                    "lightning input Documentation ";
    String text43 =
            "Actions " +
                    "Handling Client Controllers " +
                    "Which Button Pressed " +
                    "Enable Debug " +
                    "Connect " +
                    "Learning ives " +
                    " completing ’ll able " +
                    "Define apps " +
                    " fire " +
                    " other send " +
                    "Refactor big smaller " +
                    "Connect " +
                    "In we’re going tacklelast piece unfinished functionality expenses appReimbursed box ’re probably thinking implementing box would short topic could certainly take shortcuts very short topic " + "But addition making box removing ofshortcuts we’ve already taken We’re going spend “Doing Right ” few places means refactoring earlier " + "Before start let’s first talk ab shortcuts kRight whyRight bit harder better " + "Composition Decomposition " +
                    "If take source form listseparate artifacts ’ll come something following " + "expenses " +
                    "expenses cmp " +
                    "expensesController js " +
                    "expensesHelper js " +
                    "expensesList " +
                    "expensesList cmp " +
                    "expenseItem " +
                    "expenseItem cmp " +
                    "ExpensesController server " +
                    "ExpensesController " +
                    "Here’s everything comes createExpense updateExpense expense ’re wiring later " + " made many smaller " +
                    "But aton screen see see ’ll ually see everywhere thatbreaks down many ’ll see decompose further smaller pieces than we’ve Atvery least hope see thatAdd form really own separate That’s why drew box around interface " + "Why n’t form separate doing independent farbiggest shortcut k overcourse module It’s worse thanhack “disgusting ” terms software designright build compose build level features Why n’t take approach " + " kshortcut keptAdd form ins emain keptmain array andcontroller affected insame wantedcreateExpense able touchexpenses array directly we’d movedAdd form separate wouldn’t possible " + "Why coveredreason briefly very early want really hammer now supposed self contained stand al encapsulate their essential functionality owed reach another child alter internals " + "There principal interact affect another first we’ve seen quite bit already setting on’s tag ’s public constitute part API " + " second interact declare send and public constitute part of’s public API We’ve actually already h ing behind convenience features we’ll drag light few own " + " Wiring Circuit Meta or Yet Again " +
                    "These mechanisms— s—areAPI “sockets ” connect form complete circuits behindsceneselectrons flowing circuit that’s different " + "When seton button ’s direct relationship between those linked public APIs remain other coupled " + " different don’t send another That’s broadcast particular type there’s responds type “hears” act " + " think ofdifference between asdifference between wired circuits wireless circuits we’re talking wireless here doesn’t get“number” another would wireless broadcasts gets onradio sends their radio turned tuned toright frequency knowing—so it’s OK hears broadcast things might nothing crash " + "Sending " +
                    "OK enough theory let’s something see start implementingReimbursed box we’ll take learned doing refactorAdd form own Great Engineer intended " + "First let’s focus onlightning input forReimbursed__c " +
                    "Before dive let’s take step back glimpse input offer type toggle really box toggle switch design apply CSS styling SLDS utilities ToggleActive ToggleInactive prov labels for ed un ed positions handy several many others input Finallyonchange input gives us easy wiretoggle switch updates sl right ed sl left un ed " +
                    "Now let’s think happen it’s ed un ed Based oncode wrote updating probably something " + "Getexpense item changed " +
                    " server updateunderlying " +
                    "Package action " +
                    "Set callback esponse " +
                    "Fireaction sendingrequest toserver " +
                    "Whenresponse comes andcallback updateexpenses " +
                    "Um event markup again singular Hmmm right single item There’s xpensesList …but that’s comp nt even“real” expensesreal p level Hmmm " + "Is parent would parent parent —something would let us reference parent’s parent " + "Stop Right " + " reach other values There’s say “Hey grandparent I’m gonna update ” keep their hands selves wants ancestor change something asks Nicely sending " + "Here’scool part Sending almostsame handlingupdate directly Here’scode forclickReimbursed " +
                    " clickReimbursed " +
                    " let " +
                    " let update updateExpense " +
                    " update setParams expense " +
                    " update fire " +


                    "Whoa That’s pretty simple does kind envisi abovepreceding clickReimbursed doesfollowing " + "Getsexpense changed " +
                    "Creates named updateExpense " +
                    "Packages " +
                    "Fires " +
                    " callback stuff missing otherwise familiar But… ’s going callingserver andserver response updatemain array know updateExpense any " + "updateExpense ourselves un getting server instead getting doesn’t value prov er then We’ll define moment " + "As ’s going callingserver handlingresponse let’s talk could implementserver request esponse right here inexpenseItem we’d send rerender things depend xpenses array would perfectly val design choice would keepexpenseItem totally self contained desirable " + "However we’ll seecode creating andcode them updating existing very similar enough we’d prefer avo duplicate Sodesign choice we’ve made send updateExpense whichmain Later refactor form we’ll dosame creating " + "By child delegate responsibility handling server requests managingexpenses array we’re breaking encapsulation bit think child asinternal implementation details ofexpenses that’s OKmain self contained " + " choice consol ation critical logic encapsulation ’ll trade offs Aura trade offs software design sure documentdetails " + "Defining " +
                    " first thing we’ll define select File “expensesItemUpdate” Replacedefault contents following markup " + " aura type " +
                    " aura type Expense__c " +
                    " aura " +
                    "There types application Here we’re using want ancestor ancestor “above” hierarchy wanted “general broadcast” kind where could receive we’d application instead " + " full differences correct usage application vs isn’t something we’re able here It’s advanced topic enough complicated details it’s distraction purpose module ’re ready moreResources help " + " other thing notice ab compactdefinition named created expensesItemUpdate markup beginning ending aura tag aura tag ’s describepayload carry InclickReimbursed setpayload setParams Here definition see parameter defined other val parameters " + "And that’s pretty much defining don’t implementation behavior details selves packages fact don’t parameters “ happened ” ofbehavior “ ” happens defined send receive " + "Sending " +
                    " already ed actually fire inclickReimbursed last thing that’s register line markup toexpenseItem right below definitions " + " aura register updateExpense type c expensesItemUpdate " +
                    " markup says fires named “updateExpense” type “c expensesItemUpdate” wasn’t “expensesItemUpdate”name of defined it happened application types " + " ’re right think it’s confusing—it really bit switch roo might help think “application” “” Aura frame types types come names define types structure types define define package format register send declare format " + " defining registering might seem bit weird let’s ahead bit Here expenseItem we’re going send named updateExpense Later expenseForm we’re going send named createExpense Both include saved toserver both c expensesItemUpdate type package format send their " + "Onreceiving end main going register both Althoughserver ends beingsame interface updates slightly different does know whether updateexpense inc expensesItemUpdate package Byname of being sent " + "Understandingdistinction here multiple purposes light bulb moment learning haven’t had moment quite yet ’ll atrest ofcode " + "Before move handling let’s summarize takes send " + "Define creating giving " +
                    "Register send choosing type giving type " +
                    "Fire " +
                    "Using instance ";
    String text44 = "Sending fire " +
            "If went ahead implemented ofcode app ed Reload toggle Reimbursed box few missed step ’ll error re because everything right…hey waitexpense changes color show Reimbursed status expected " + " behavior present started That’seffect oflightning input value Reimbursed__c toggleswitchlocal version ofexpense updated change isn’t being sent toserver atexpense reloadwon’t seechange " + "Why We’ve half of complete circuit finish wiringcircuit creating onother take care sendingchange toserver makingupdate durable " + "Handling " +
            "EnablingexpenseItem send required three steps Enablingexpenses receive requires three parallel steps " + "Define We’ve already expenseItem sendingsame receiving " +
            "Register maps " +
            "Actually " +
            "Since we’ve already step let’s immediately turn step register receive updateExpense registering send registering single line markup toexpenses right init " + " aura updateExpense c expensesItemUpdate" +
            " init saura tag setscontroller for registered expenseItem here setname type of —though ofmuch sensibly named fortype " + "In other there’s much here haven’t seen ’s handling iscombination of knowing receiver “socket” matches sender “socket” expenseItem " + " completeswiring part making that’s left actually action " + "We’ll start UpdateExpense Here’scode sure put riiiiiight under " + " UpdateExpense " +
            " let updatedExp getParam " +
            " updateExpense updatedExp " +

            "Huh That’s interesting Except forform val ation and we’re delegating issame CreateExpense " + "And now let’s addupdateExpense action sure put right belowcreateExpense " + " updateExpense " +
            " let c saveExpense " +
            " setParams " +
            " expense " +

            " setCallback response " +
            " let state response getState " +
            " state SUCCESS " +
            " nothing " +


            " $A enqueueAction " +

            "Two things notice right offbat First except forcallback supdateExpense entical tocreateExpense smells opportunity " + "Second those callback gives canright thing nothing " + "Think moment Earlier sending saw thatexpenseItem ’s color changed response togglingReimbursed box Rememberexplanation local ofexpense already updated least formoment whenserver tells us successful updating version don’t anything " + " scase whereserver successful updatingexpense We’d definitely error Say Accounting flagged non reimbursable making impossible true say lesson another day " + "RefactorHelper Functions " +
            "Let’s go back opportunity saw factor common codetwo functions entical except forcallback let’s generalized takescallback parameter " + " saveExpense callback " +
            " let c saveExpense " +
            " setParams " +
            " expense ";
    String text45 =
            " callback " +
                    " setCallback callback " +

                    " $A enqueueAction " +

                    " callback parameter optional it’s we’ll pass along Simple now reduce functions tofollowing " + " createExpense " +
                    " saveExpense response " +
                    " let state response getState " +
                    " state SUCCESS " +
                    " let " +
                    " push response getReturnValue " +
                    " expenses " +


                    " updateExpense " +
                    " saveExpense " +

                    "createExpense shorter it’s exclusively foc whenresponse comes backcallback wow updateExpense liner " + "RefactorAdd Form " +
                    "That refactoring exercise satisfying we’re sorry electrifying let’s again bigger cowbell " + " next task involves extractingAdd form moving own Extractingform markup easy enough simple paste exercise moves it start moving pieces around willy nilly let’s think moves stays " + "Incurrent designform’s input val ation sendingrequest toserver updating local state interface sform probably form val ation we’ll rest stay behind we’re keeping server request logic consol ated inexpenses " + "So there’s teasing apart start movingform markup move possible correctly We’ll refactor both communicate via instead via direct access toexpenses array " + "Let’s started " + "Inmain select everything betweentwo comments includingbeginning ending comments selves Cut clipboard Yes cut We’re committed " + " Aura “expenseForm” Pastecopied form markup int w betweenaura tags " + "Back toexpenses Addnew expenseForm tomarkup section " + " FORM " +
                    " lay " +
                    " lay Item padding around small size " +
                    " c expenseForm " +
                    " lay Item " +
                    " lay " +
                    "At reload seechanges visible changes unsurprisingly button longer " + "Let’s rest ofmoving things around part " + "Next movenewExpense toexpenseForm markup forform needs inform moves over changes required cut paste inother " + "InexpenseForm createcontroller resources " + "Move toexpenseForm controllerbutton inform soaction forbutton needs Believe needs changes might begin sensing here " + "Now couple actual changes familiar we’re adding sending expenseItem expenseItem ’ll recall sends payload byexpenses " + "InexpenseForm createcreateExpense " + " createExpense newExpense ";
    String text46 = " let create createExpense " +
            " create setParams newExpense " +
            " create fire " +

            " very much clickReimbursed expenseItem " + "If going send needs register Addfollowing toexpenseForm markup belownewExpense " + " aura register createExpense type c expensesItemUpdate " +
            "At we’ve implementexpenseForm able reloadandform now “ s” insense errors seeappropriate form enter ’re usingSalesforce Inspector see thatexpensesItemUpdate being fired that’s left " + "Before please notice easy refactoring Most ofcode n’t change There’s total six lines markup inpreceding steps It’s unfamiliar today few realize ’re moving bit around " + "OK let’s finish expenseForm firescreateExpense needexpenses First registercreateExpense wire to CreateExpense again single line markup line right above belowupdateExpense " +
            " aura " +
            "Finally forlast step create CreateExpense inexpenses right above below UpdateExpense " + " CreateExpense " +
            " let newExpense getParam " +
            " createExpense newExpense " +

            " together Yep simple of delegated tocreateExpense n’t move change CreateExpense wireright things " + "And we’re finished showing loosely couple fire another Wireless circuits " + "Bonus Lesson—Minor Visual Improvements " +
            "Before head off sunset challenge here modest visual improvement " + "We’d improvelay bit adding few container last bit gives opportunity seefull changes Inexpenses replaceexpensesList markup following " + " lay " +
            " lay Item padding around small size " +
            " c expensesList " +
            " lay Item " +
            " lay Item padding around small size " +
            " Put something cool here " +
            " lay Item ";
    String text47 = " lay " +
            " effects ofchanges margins padding expenses narrowlay leaves room put something over onright Innext we’ll suggest couple exercises could own " + "Resources " +
            "Communicating " +
            "Actions " +
            "Handling Client Controllers " +
            " Handling Base " +
            "Invoking Actions Initialization " +
            "Detecting Changes " +

            "Handling " +
            "Dynamically Showing H ing Markup " +
            "Application " +
            "Handling Application " +
            " Handling Lifecycle " +
            "Advanced ";
    String text48 = "Integrated database—It straightforward access manipulate prov es direct access their prov es languages manipulate those " +
            "Data foc d— prov es transactional access todatabase owing roll back operations " +
            "Easy — based familiar Java ioms " +
            "Easy test— prov es built support creation execution expected executing prior platform upgrades " +
            "Versi d— saved against different versions ofAPI " +
            " cloud based " +
            " Highlights " + " other oriented languages oflanguage constructs supports " + "Classes interfaces properties collections including arrays " +
            " array notation " +
            "Expressions variables constants " +
            "Conditional control flow loops loops " +
            "Un other oriented languages supports " + "Cloud development stored compiled executed incloud " +
            "Triggers similar triggers systems " +
            "Database ow direct calls languages " +
            "Transactions rollbacks " +
            " global access modifier permissive thanpublic modifier ows access across namespaces applications " +
            "Versioning custom ";
    String text49 = " chase Virginia Woolf object Joyces Ulysses being prurient contained tropes ineluctable modality ofvisible Joyce himself ref alter single line his" +
            " short story Ivy Day inCommittee Room poking fun Prince Wales his publisher delayed publication than decade" +
            "To contemporary audience who access gra ic pornogra ic imagery treasonable extremism few facile keystrokes taboos appear absurd yet large part cultural ofth Century inWest least was" +
            " taken battle another asterritory deemed conquered renamed commonplace" +
            " problem atsame victories were being won another province being aband fight isrealm where films paintings newspaper articles radio television programmes intellectually" +
            " dont moment mean suggest no produces anymore cultural artefacts sense course longer regarded asdes erata wellcultivated person aspires to" +
            " appreciation parcelled off andgreat plurality ubiquity media means their specialist audience readily catered whether foot fetishists Fourierists anything else"
            + " The suspicion mass media lead banal m dlebrow culture old asprinting press arguably older given Plato writing itself lerable derogation ofpoetry ofspoken vantage" +
            " successive wave crest popularisation anxieties preceding generations seem touchingly premature"
            + "Take cultural critic Dwight MacDonald who coinedexpression m cult refer those pretend thought respectstandards high culture fact water down vulgarize MacDonald writing at" +
            " novel American history " +
            "Aha say purely titillating subject matter I would reply Quite possibly along paedo ilia Nabokov managed thrust his readers tender lexicons many other as" +
            " grue heliotropic solipsism venus febriculosa often rate than page " +
            " coinc ence kinds y I believe nothing ofkind attempting push forward realm deadening conformity artists rs ofth Century employed weapons were hand" +
            " making their intellectually challenging deflectedaccusation their sexual violent content aro Recall defence against charge obscenity remains day exhibit " +
            "genuine artistic merit" +
            "But now subject matter exactly permitted readily accessible cultural artificers aim high displacement aesthetically intellectually art aszenith resulted " +
            "sorts sad inter related enomena" +
            "Inliterary world books intended child readers repackaged sold k ult notionally highbrow arbiters Booker judges obsessed na ous confection jolly read Shakespeare remains our" +
            " national frankly bizarre given his recondite vocabulary myriad historical references convoluted meta orical language were he seeking publication incurrent milieu his sonnets plays would undoubtedly branded fast culture peril unusual art us says Self" +
            " living riskaverse culture theres doubt that" +
            "Butrisk people seem most reluctant taking ysical mental asconcrete childrens play covered rubber sohard truth ab effort intellectual attainment being softened sort semantic padding" +
            "Our arts humanities education secondary level seems particularly afflicted falling standards much universities now being upon help Alevel syllab order cram chicks knowledge recent years come seem unpalatable indigestible knowledge English vocabulary beyond common usage" +
            "Both general readers specialist critics often complain my own English my books my newspaper articles radio talks I dictionary complain were kind torture" +
            "In over twenty years publishing fiction journalism Ive become pretty much inured slings arrows regarding par forantiintellectual course I remonstrate those who raisedS being sesquipedalian obscure means lover obscure s" +
            " my texts were full resolutely AngloSaxon slang wereflowery andLatinate observe English being mishmash several different languages had large exciting vocabulary seemed shame especially given went growing spawning argot specialist terminology freely oyster does milt";
    String text50 = "But g Ive stopped bothering ofgreat things writing opposed other media claims people unless engage no" +
            " matter torturous don t leap books articles assault go ing now I confine myself makingrueful althoughsubject matter my stories " +
            " enomena sexual deviance drug addiction mental illness become quite unexceptionablesupposedly couched seems become more" +
            " offensive readers iskey here Inpast before ering a censorship wasdepiction sexuality andbodily general anything smacking antiauthoritarianism " +
            "that perceived visual artscurrent Damien Hirst retrospective Tate Modern perfect opportunity see becomes artificer whose impulse towards subject matter unsupported " +
            "by capacity hard cogitation challenging artistryearly sstuffed animals flybedizened carcasses retain certain albeit recherché shock value subsequent degenerate steadily tocondition" +
            " knockedoff merchandise makingbarrier betweengift shop andexhibition space evaporate puff consumerism Butmost disturbing retreat arts humanities " +
            "education wheretraditional set texts now chopped b less nuggets McKnowledge students encouraged their research onweb place of y involved seeking literary " +
            "canon nger people coming rely engines their thinking end standardisation understanding itself people become unable think ofboxshaped screennadir " +
            "came my daughter who had assigned Great Expectations GCSE text told ending her English teacher read gobbets served interpretation according her " +
            "pedagogue necessity her try choke downwhole indigestible meal My figures food entirely fitting danger becoming morb ly obese consumption fast culture The" +
            " contrast sport instructive both realms human endeavourconsumers largely passive least sports fans un cultural dont protest against elite athletes bar competing " +
            " fast strong limber Oncontrary repeatedly told by Sebastian Coe athletes capable ofmost feats offer vital inspiration couchpotato k Letsame se for";
    String text51 = " mental athletics bar jump over high well end simply playing insandpit readers welleducated group expect so isticated literate prose delight writing " +
            "and don’ t shy a complicated topics Onother hand probably don’ t carry unabr ged dictionary along newspaper takesub don’ t expect news article posesame linguistic " +
            "challenge “ Finnegans Wake ” choice should ful precise never talk down readers often reader come across hagiogra y antediluvian peripatetic " +
            "especially breakfast benefit readingTimes online is“ up” double question mark appears Clickquestion mark definition Heritage " +
            "Dictionary My colleague James Robinsondirector Web analytics shared intriguing been list good of had ed most often readers year list few " +
            " caution Don’ t takeprecise ranking numbers literally Obviously often ed depends partly much it’ many people reading article online Tom Friedman " +
            "moderately unusual say fealty I real headscratcher onsame day say it’ bet readers his remember I’ m trying ban challenging " +
            " may perfectly justified keep mind why we’ re writing who’ reading under circumstances avo temptation display erudition atreader’ sa here’ slist " +
            " Check out few final comments I’ ll admit were onlist had thoroughly stumped sumptuary “ regulating expenditures specif seeking regulate extravagance " +
            "religious moral ” “ imaginary believed ca combustion given off anything burning” handling “ ”though showed help readers tricky " +
            " don’ t quote Science story ysicists who Wall Street gavebackground using easy eas economic literature" +
            " many quants complain J Doyne Farmer ysicist professor atSanta Fe Institute andfounder former chief scientist ofPrediction Company sa he shocked he started reading finance literature " +
            "backward comparing M dleAges theories fire “ were talking — notright meta or ” Dr Farmer sa entries seem selfreferential it’ coinc ence obscure ";
    String text52 =
            " abstr recondite mention some solipsistic many foreign actually sui generis bildungsroman my old friend schadenfreude appearances " +
                    "some entries seem baffling end louche Remember striking very become wan devalued over Cons er apotheosis we’ somehow managed " +
                    "far year literally means “deification transformation divinity ” extended meaning “ glorified eal ” seems suggest than “ pretty ” Most recently we’ " +
                    "ve sa critics viewCl n healthcare “apotheosis liberal ofcontrol bureaucracybuilding ” we’ described cutoff shorts “ apotheosis laissezfaire wear ” say some really " +
                    "is transformed god Deadline examines questions grammar usage style encountered rs editors ofTimes adapted weekly newsroom critique overseen ilip B Corbettdeputy news editor" +
                    " who charge ’ style manual Ikinci Algoritmasi Herkese ileri Merhabalar Önceki yazılarımı okuyarak yazima geldiginizi umuyorum Boylece oyunun nasil oynandigini adim bildiginizi ilk algoritmasini incelediginizi" +
                    " varsayarak yazima devam edecegim okumadiysaniz konuya hakim ola acaginiz onceki yazilarimi okumanizi tavsiye ederim Ikinci Algoritmasi Uygun Hesaplama sonraki i attiktan sonra oyunun asamalarinda" +
                    " tur durumlarla karsilasabilecegini buna gore Sonraki da neler olacagini hesaplayip gore y lik programlanmis algoritmadir Halk agziyla tabir edecek olursak cikmaz sokagi kestirip una gore " +
                    "veya atiyor Bundan sonra ilerlenebilecek uygun kareler cikmaz sokaga cikiyorsa karelere olumcul diyecegim algoritma kareye erisim saglanabilecek karelerin doldurulmasini engellemesi uzerine kodlanmistir" +
                    " Yani sayede kareye hic sekilde erisim ol acaksa o halde atarak gereksiz calismasin atsin mantigiyla calismaktadir Bunun cok basit islemi ekledim Islemi Algoritmanin " +
                    "ileri m atma islemine karar vermesi gerekiyor karari hesaplayacak fonksiyonun adina DeadlyPoint ismini verdim Boylece fonksiyon olumcul varsa atma komudu aksi halde atma komudu verecektir" +
                    " fonksiyonda degisken kullanilmaktadir Bunlar g ilebilecek yonler degiskenler ir kavrami demek Located gorselinde uygun kareler kirmizi cerceveli beyaz " +
                    "karelerde gosterilmistir Sol ustteki beyaz karenin uygun karenin kareye ilerlenilirse ol acaktir Ancak kareye ilerlenilmedigi takdirde degiskende degisikli olusur Degisen degisken " +
                    "ise cikis deger ir Son atacagi belirlendigi da belirlenmis oluyor olarak belirlenen ilerlenilecek son olmal ir belirlendikten sonra tekrardan " +
                    " nin belirlenmesi soz konusu oldugunda kare atilmasi gerekmektedir Available Squares Available Squares gorselinde sol ust beyaz karenin Bunlardan tanesine da doldurulmus Di da" +
                    " doldurulmus ye kareye ulasilabilecek kaliyor O kareyi de da doldurulmus Burada algoritma yonlerin yonlerini hesaplar yonlerin yonlerini";
    String text53 =
            " kavrami demek ilerleyebilecegi yonlerinden tanesinin hesaplanmis u bulunmus Onceden halini Forward available squares calculation gorselinde cizimlerle anlattim Neden hesapla i yapiyoruz Iki nedeni " +
                    "var Birinci nedeni Bulunulan icin var ilerlenebilecek yon kac tane tek Hesaplanilan islemimizde kullanicagiz Ikinci nedeni Sonraki ilerleyebilecek hesaplanirsa oyun bitmiyor o" +
                    " halde program atmasini saglayacagiz sayede verimsiz calis i ortadan kaldiracagiz yonlerden tanesine atildigi takdirde diger olarak belirlenmis olacaktir dan sonraki" +
                    " butun islemler gerceklestirildigini sayalim Tekrardan geldik sefer attigimiz kareyi olarak belirleyecegiz olarak belirledigimiz kareye atacagiz Tekrardan " +
                    "ilerisi islemler yapildigini varsayalim Tekradan geldik sefer her iki yonu olan kareye atilip hesaplamalar yapildigi artik atacagiz Forward Number Located gorselleri " +
                    "ve aciklamalariyla farkli ozel durumu anlattim Artik iki kavram bildigimize gore formulunu inceleyebiliriz Math taraf atilmasi uygun olan karelerin tanesinin atabilecegi yonu " +
                    "oldugunun de alinir belirlenmis Exit Situation belirlenmemis Asag takim ornekler verilmistir islemini yapabilmek her iki degiskeninde de " +
                    " bulunmaktadir verilen Eger Simdi bilgilere gore islemimizi yapalim belirsiz oldugunu varsayarak islem yapalim belirsiz islemimizin dogrulugunu " +
                    "Tek sayimiz olunca atmamiz gerekiyor Bunun yukar incelemistik O halde yapilan islem dogru belirsiz belirsiz islemimizin Square dogrulugunu" +
                    " edelim sayimiz olunca yonlerden birisine ilerliyorduk Sonra tekrar geri gelince sefer diger y ilerliyoruz Bunu yukar incelemistik O halde yapilan islem dogru " +
                    "belirli sayisi olursa Matematik islemimizin dogrulugunu sayimiz olunca yonlerden birisinden ilerleyip diger yonu yapiyoruz burada farkli durum zaten " +
                    "belirlenmis tane olamaz yuzden atilmali O halde yapilan islem dogru Ilk algoritmasi olan oyun modlarinin rapo u inceledik Ikinci algoritmasi ayni oyun modlarinin rapo u cikardim";
    String text54 =
            " Iki rapo u da karsilastiralim Speed Comparison mode Speed Comparison far game Chart gorselini inceliyecegiz Tablonun her iki tarafinda lik oyunu modunun raporu Tablonun sol tarafi birinci algoritmasi" +
                    " hesaplanmistir Tablonun Solution tarafi ikinci algoritmasi hesaplanmistir Ikinci algoritma birinci algorit gore lik oyun modunda kisa kisa surede cozmustur Milisaniye esas alinmistir dongusune girmistir" +
                    " cozemeyecegi yonlere dogru atmistir karsilastir bakarak sizce oyun modu kadar surede cozmustur Yaklasik olarak saat arasi mi vakit almistir sdersiniz Hadi lik oyun modu kiyaslama yapalim Speed Comparison " +
                    "Chart Speed Comparison gorselini inceleyelim onceki tabloda inceledigimiz gibi sol birinci algoritmasinin ikinci algoritmasinin rapo u icermektedir kisa surede cozmustur Saniye" +
                    " esas alinmistir while dongusune girmistir BUNUN BIRINCI ALGORITMAIN COZULMESI BEKLENIYOR cozemeyecegi yonlere dogru atmistir Coordinate Representation Coordinate Representation gorseli Squares " +
                    "Number gorselini Squares Number gorselini inceleyip her karede toplam sayisini gorebilirsiniz gorsellerden oyun modu hesaplanmis koordinat ni secip inceleyelim Coordinate Representation gorselinde " +
                    "gosterildigi uzere sol alt kareye ilk atildiktan sonra islemler gerceklestirilmistir Bulunulan toplam tanedir karenin her biri bunlar hesaplanmistir adet toplam koordinatlarda sekilde dagilmistir" +
                    " Squares Number Number Lik deneme likIkinci algoritmanin birinci algorit gore cok hizli oldugunu kanitladik Peki hiz yeterince iyi olup olmadigini nasil edicegiz Bunun oyun modunu ust " +
                    "sayiya cikarip daha de ettim Malesef ve kareleri cozmesi bekleyemedim koordinattaki sayisini bulabildim lari inceleyelim milyon saatte cozdu Milyardan fazla dongusune girdi Algoritma skor ala acagi halde halde" +
                    " atip sonra attigi zaman kaybi yasaniyor u ortadan kaldirdigim vakit belk saat oyun modundaki cozumleri bulabilecegim Aklimda algoritma takim fikirlerim Ancak universite " +
                    "ogrencisi oldugum derslerim sinavlarim cok vaktimi aliyor Yeterince odaklanamiyorum harika algoritmasi yazmak sabirsizlaniyorum Calcuate Minimum Different Squares Squares Number s" +
                    "Solution Number gorselinde seyin dikkatinizi cektigini umuyorum tane farkli karede de sayilardan olusuyor Calcuate Minimum need Different Squares gorselinde anlatildigi " +
                    "uzere aslinda tane karedeki sayilari hesaplanirsa moddaki toplam hesaplanabilir Mesela mavi reng eki karenin de hesaplandigini varsayalim karenin simetrileri olucak sekilde tane ayni cozumu " +
                    "sadece toplam sayisini bulmak istiyorsak karenin hesaplanmasi carpilmasi bize zaman kazandiracaktir Yani toplamda kareyi hesaplamak yerine karedeki cozumu hesaplamamiz yeterli olucaktir ";
}

*/
