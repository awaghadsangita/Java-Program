const utility=require('./Utility/Utility');
distance=()=>{
    console.log('Enter value for x coordinate and for y coordinate');
    let x=utility.getFloatInput();
    let y=utility.getFloatInput();
    
    let dist=utility.calculateDistance(x,y);
    console.log(`Distance from origin(0,0) to (${x},${y}) : ${dist}`);
}

module.exports=distance();