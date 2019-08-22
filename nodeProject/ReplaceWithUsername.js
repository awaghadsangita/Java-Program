const readInput=require('./Utility/Utility');
var givenString="Hello <<UserName>>, How are you?";
do{
    console.log("Enter User Name");
    var username=readInput.getString();
    if(username.length<3)
        console.log("Username must contain atleast 3 Characters");
}while(username.length<3);

console.log(givenString.replace("<<UserName>>",username));