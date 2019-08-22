const utility=require("./Utility/Utility");

generateCoupanNumber=()=>{
    console.log("How many coupan you want to generate :");
    let noOfCoupan=utility.getInputNumber();

    let coupans=utility.generateCoupanNumbers(noOfCoupan);
    console.log("Coupon Numbers are as follow");
    for(let i=0;i<noOfCoupan;i++)
    {
        console.log(`${i+1} Coupon Number : ${coupans[i]}`);
    }

}
module.exports=generateCoupanNumber();