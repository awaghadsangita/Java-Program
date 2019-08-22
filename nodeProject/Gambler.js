const utility = require("./Utility/Utility");

gambler = () => {
    console.log("enter $stake amount");
    var stake = utility.getInputNumber();
    console.log("enter $goal amount");
    var goal = utility.getInputNumber();
    console.log("how many times you want to play");
    var bets = utility.getInputNumber();

    var results = utility.gamblerGame(stake, goal, bets);
    console.log(results);
    var winPercentage = parseInt(results["winCount"]) * 100 / parseInt(results["bets"]);
    var loosPercentage = 100 - winPercentage.toFixed(2);
    console.log(`Win Percentage :${winPercentage}`);
    console.log(`loose Percentage :${loosPercentage}`);
    if (results["isWin"]) {
        if (results["isAchiveGoal"]) {
            console.log("user win and achieve goal");
        }
        else {
            console.log("user win BUT NOT achieve goal");
        }
    }
    else {
        console.log("user loose game");
    }
}

module.exports = gambler();