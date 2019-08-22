const utility=require("./Utility/Utility");

PrimeFactors=()=>{
    console.log("Enter Number to calculate Prime Factor :");
    var number=utility.getInputNumber();
    var primefactor=utility.calculatePrimeFactor(number);
    console.log(`Prime Factor of ${number} \n${primefactor}`);

}
module.exports=PrimeFactors();