const utility=require('./Utility/Utility');

permutation=()=>{
    console.log("enter string to find all permutation :");
    let string=utility.getString();
    let totalPermutation=1;
    for(let i=1;i<=string.length;i++)
    {
        totalPermutation*=i;
    }
    let permutationArray=[];
    permutationArray  = utility.findPermutation(string,0,string.length-1,totalPermutation);
    console.log("Total Permutations are as follows");
    console.log(permutationArray);
}
module.exports=permutation();