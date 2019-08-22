const utility=require("./Utility/Utility");

stopwatch=()=>{
    console.log("Press 1 to start StopWatch");
    let start=utility.getInputNumber();
    let starttime;
    let stoptime;
    if(start==1)
    starttime=Date.now();
    console.log("Press 0 to stop StopWatch");
    let stop=utility.getInputNumber();
    if(stop==0)
    stoptime=Date.now();

    let elapsetime=stoptime-starttime;
    let seconds=Math.floor(elapsetime/1000);
    console.log(`Elapsed Time in seonds:${seconds}`);

}

module.exports=stopwatch();