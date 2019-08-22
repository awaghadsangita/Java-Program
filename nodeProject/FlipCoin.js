const utility=require('./Utility/Utility');
console.log("How many times you want to filp");
var noOfFilips=utility.getInputNumber();
var headCount=0;
var tailCount=0;
do{
    var rand=Math.random();
    if(rand<0.5)
    {
        headCount++;
        console.log("you flip HEAD");
    }
    else
    {
        tailCount++;
        console.log("you flip Tail");
    }
}while((headCount+tailCount)<noOfFilips);
console.log("HEAD Percentage :"+headCount/noOfFilips*100);
console.log("TAIL Percentage :"+tailCount/noOfFilips*100);
