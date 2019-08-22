const utility=require("./Utility/Utility");
windChill=()=>{
    console.log("Program To Calculate WindChill Temperature");
		
    let t=parseFloat(process.argv[2]);
    let v=parseFloat(process.argv[3]);
    
    if(Math.abs(t)>50 || v>120|| v<3)
    {
        console.log("formula is not valid if Temperature(t) is larger than 50 in absolute value or if Wind Speed(v) is larger than 120 or less than 3");
    }
    else
    {
        let windChillTemperature= 35.74 + 0.6215 * t+(0.4275 * t-35.75)*Math.pow(v,0.16);
        console.log("Wind Chill :"+windChillTemperature);
    }
}
module.exports=windChill();