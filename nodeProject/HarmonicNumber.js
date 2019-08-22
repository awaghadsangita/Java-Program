const utility=require("./Utility/Utility");

HarmonicNumber=()=>{
    console.log("Enter the Harmonic Value (N) :");
    var n=utility.getInputNumber();
    var harmonicValue=0;
    var harmonicSerise="";
    for(let i=1;i<=n;i++)
    {
        harmonicSerise=harmonicSerise+" 1/"+i;
        harmonicValue=harmonicValue+1/i;
        if(i!=n)
        harmonicSerise+=" +";
    }
    console.log(`Harmonic Serise :${harmonicSerise} = ${harmonicValue.toFixed(2)}`);
}

module.exports=HarmonicNumber();