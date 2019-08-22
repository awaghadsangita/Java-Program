const utility = require("./Utility/Utility");
do {
    console.log("Enter Year");
    var year = utility.getInputNumber();
    var temp = year;
    var count = 0;
    while (temp >= 1) {
        count = count + 1;
        temp /= 10;

    }
    console.log(count);
    if (count != 4)
        console.log("year must be four digit");
} while (count != 4);

var isLeap = utility.isLeapYear(year);
if (isLeap)
    console.log(`${year} is leap year`);
else
    console.log(`${year} is NOT leap year`)