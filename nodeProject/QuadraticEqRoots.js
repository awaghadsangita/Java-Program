const utility = require("./Utility/Utility");
quadratic = () => {
    console.log("Enter value for a,b,c (ax^2+bx+c=0) quadratic equation");
    let a = utility.getInputNumber();
    let b = utility.getInputNumber();
    let c = utility.getInputNumber();
    let roots;
    if (a > 0) {
        roots = utility.findRoots(a, b, c);
    }
    else {
        console.log("a can not be zero for quadratic queation");
    }
    console.log(roots["quote"]);
    console.log(`First Root :${roots["firstroot"]}`);
    console.log(`Second Root :${roots["secondroot"]}`);
}
module.exports = quadratic();