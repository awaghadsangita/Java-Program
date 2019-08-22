const utility=require('./Utility/Utility');

sumofThreeInteger=()=>{
    console.log(`how many element you want in array`);
    let size=utility.getInputNumber();
    let a=[];
    console.log(`enter the ${size} integer elements`);
    for(let i=0;i<size;i++)
    {
        a[i]=utility.getInputNumber();
    }
    for(let first=0;first<size-2;first++)
    {
        for(let second=first+1;second<size-1;second++)
        {
            for(let third=second+1;third<size;third++)
            {
                if(a[first]+a[second]+a[third]==0)
                {
                    console.log(`${a[first]}+${a[second]}+${a[third]}=0`);
                }
            }
        }
    }
}

module.exports=sumofThreeInteger();