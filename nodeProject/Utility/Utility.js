/**
 * @purpose :contains all methods which are require frequently in different module
 * @author  :sangita awaghad
 * @since   :21-08-2019
 **********************************************************************************/
const readInput = require('readline-sync');
let permute = [];
let count = 0;
module.exports = {

    /**
     * return string containing only letters
     */
    getString() {
        var format = /^[a-zA-Z]{1,}$/;
        var inputString = readInput.question();

        if (format.test(inputString)) {
            return inputString;
        }
        else {
            throw new Error('input must contain letters only');
        }
    },
    /**
     * return number from keyboard
     */
    getInputNumber() {
        return readInput.questionInt();
    },
    /**
     * return float number from keyboard
     */
    getFloatInput() {
        return readInput.questionFloat().toFixed(2);
    },
    /**
     * return boolean number from keyboard
     */
    getBooleanInput() {
        return readInput.question();
    },

    /**
     * return true if year is leap year
     */
    isLeapYear(year) {
        var isLeap = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeap = true;
                }
                else {
                    isLeap = false;
                }
            }
            else {
                isLeap = true;
            }

        }
        else {
            isLeap = false;
        }
        return isLeap;
    },
    /**
     * return prime factors in string format
     */
    calculatePrimeFactor(number) {
        var temp = number;
        var primefactor = "";
        for (let i = 2; i * i < number; i++) {
            if (temp % i == 0.0) {
                primefactor = primefactor + i + " ";
                temp /= i;
            }
        }
        if (temp > 2) {
            primefactor = primefactor + temp;
        }
        return primefactor;
    },
    /**
     * return associative array of win count ,loosecount,is achieve goal,is win variables
     */
    gamblerGame(stake, goal, bets) {
        let betsCount = 0;
        let winCount = 0;
        let looseCount = 0;
        let isWin = false;
        let cash = stake;
        let isAchiveGoal = false;
        while (betsCount < bets) {
            betsCount++;
            if (Math.random() > 0.5) {
                winCount++;
                cash++;
            }
            else {
                looseCount++;
                cash--;
            }
            if (cash == goal) {
                isAchiveGoal = true;

                break;
            }
        }
        if (cash > stake)
            isWin = true;
        var result = { "looseCount": looseCount, "winCount": winCount, "isWin": isWin, "bets": betsCount, "isAchiveGoal": isAchiveGoal };
        return result;
    },
    /**
     * return array of distance coupon numbers
     */
    generateCoupanNumbers(noOfCoupans) {
        let coupans = new Array(noOfCoupans);
        let count = 0;

        for (let j = 0; j <= noOfCoupans; j++) {
            let k = 0;
            let coupannumber = Math.ceil(Math.random() * noOfCoupans);
            for (let i = 0; i < j; i++) {
                if (coupans[i] == coupannumber)
                    break;
                k++;
            }
            if (j == k) {
                coupans[count] = coupannumber;
                count++;
            }
            j = count;
        }

        return coupans;
    },
    /**
     * return distance from origin(0,0) to point(x,y)
     */
    calculateDistance(x, y) {
        let distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    },
    /**
     *return all permutation of given string 
     */
    findPermutation(word, l, r, totalPermute) {
        if (l == r) {
            permute[count] = word;
            count = count + 1;
            if (count == totalPermute) {
                let i, j, k = 0;
                for (i = 0; i < totalPermute; i++) {
                    for (j = 0; j < i; j++) {
                        if (permute[j].localeCompare(permute[i]) === 0)
                            break;
                    }
                    if (i == j) {
                        permute[k] = permute[i];
                        k++;
                    }
                }
                console.log(permute);
                return permute;
            }
        }
        else {
            for (let i = l; i <= r; i++) {
                word = this.swapString(word, l, i);
                this.findPermutation(word, l + 1, r, totalPermute);
                word = this.swapString(word, l, i);
            }
        }
    },
    /**
     * swap alphabets at position l and i of string
     */
    swapString(string, l, i) {
        let array = string.split('');

        let temp = array[l];
        array[l] = array[i];
        array[i] = temp;

        string = array.join('');
        return string;
    },
    /**
    * return roots of quadratic equation 
    */
    findRoots(a, b, c) {
        let delta = b * b - 4 * a * c;
        let roots = [];
        if (delta > 0)// if delta is greater than zero then roots are real and different
        {
            root1 = Math.floor((-b + Math.sqrt(delta)) / (2 * a));
            root2 = Math.floor((-b - Math.sqrt(delta)) / (2 * a));
            roots = { "quote": "roots are real and different", "firstroot": root1, "secondroot": root2 };
        } else if (delta < 0) // if delta is less than zero then roots are complex
        {
            let sqrt_avl = Math.sqrt(delta);
            roots = { "quote": "roots are complex", "firstroot": `( ${-b} + ${sqrt_avl}i)/${2 * a})`, "secondroot": `( ${-b} - ${sqrt_avl}i)/${2 * a})` };
        }
        return roots;
    },
    /**
     *  display board for Tic Tac toe Game 
     */
    displayBoard(board) {

        console.log(`\t\t| ${board[0][0]} | ${board[0][1]} | ${board[0][2]} |`);
        console.log(`\t\t|---|---|---|`);
        console.log(`\t\t| ${board[1][0]} | ${board[1][1]} | ${board[1][2]} |`);
        console.log(`\t\t|---|---|---|`);
        console.log(`\t\t| ${board[2][0]} | ${board[2][1]} | ${board[2][2]} |`);

    },
    /**
     * user enter position.program check the availability of position
     */
    userTurn(checkPossibility) {
        let position;
        // do {
            console.log("Enter the Value");
            position= this.getInputNumber();
            switch (position) {
                case 1: if (checkPossibility["board"][0][0] == 'X' || checkPossibility["board"][0][0] == 'O') {
                    this.userTurn(checkPossibility);
                }
                else {
                    console.log("1111");
                    checkPossibility["board"][0][0] = 'X';
                    checkPossibility["countX"]["count1"]++;
                    checkPossibility["countX"]["count4"]++;
                    checkPossibility["countX"]["count7"]++;
                }
                    break;
                case 2: if (checkPossibility["board"][0][1] == 'X' || checkPossibility["board"][0][1] == 'O') {
                    this.userTurn(checkPossibility);
                }
                else {
                    checkPossibility["board"][0][1] = 'X';
                    checkPossibility["countX"]["count5"]++;
                    checkPossibility["countX"]["count1"]++;
                }
                    break;
                case 3: if (checkPossibility["board"][0][2] == 'X' || checkPossibility["board"][0][2] == 'O') {
                    this.userTurn(checkPossibility);
                }
                else {
                    checkPossibility["board"][0][2] = 'X';
                    checkPossibility["countX"]["count1"]++;
                    checkPossibility["countX"]["count6"]++;
                    checkPossibility["countX"]["count8"]++;
                }
                    break;
                case 4:
                    if (checkPossibility["board"][1][0] == 'X' || checkPossibility["board"][1][0] == 'O') {
                        this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][0] = 'X';
                        checkPossibility["countX"]["count2"]++;
                        checkPossibility["countX"]["count4"]++;
                    }
                    break;
                case 5:
                    if (checkPossibility["board"][1][1] == 'X' || checkPossibility["board"][1][1] == 'O') {
                        this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][1] = 'X';
                        checkPossibility["countX"]["count5"]++;
                        checkPossibility["countX"]["count2"]++;
                        checkPossibility["countX"]["count7"]++;
                        checkPossibility["countX"]["count8"]++;
                    }
                    break;
                case 6:
                    if (checkPossibility["board"][1][2] == 'X' || checkPossibility["board"][1][2] == 'O') {
                        this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][2] = 'X';
                        checkPossibility["countX"]["count6"]++;
                        checkPossibility["countX"]["count2"]++;
                    }
                    break;
                case 7:
                    if (checkPossibility["board"][2][0] == 'X' || checkPossibility["board"][2][0] == 'O') {
                        this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][0] = 'X';
                        checkPossibility["countX"]["count3"]++;
                        checkPossibility["countX"]["count4"]++;
                        checkPossibility["countX"]["count8"]++;
                    }
                    break;
                case 8:
                    if (checkPossibility["board"][2][1] == 'X' || checkPossibility["board"][2][1] == 'O') {
                        this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][1] = 'X';
                        checkPossibility["countX"]["count3"]++;
                        checkPossibility["countX"]["count5"]++;
                    }
                    break;
                case 9: if (checkPossibility["board"][2][2] == 'X' || checkPossibility["board"][2][2] == 'O') {
                    this.userTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][2] = 'X';
                        checkPossibility["countX"]["count6"]++;
                        checkPossibility["countX"]["count3"]++;
                        checkPossibility["countX"]["count7"]++;
                    }
                    break;

            }
        // } while (position < 1 || position > 9);
        return checkPossibility;
    },
    /**
     * computer enter position.program check the availability of position
     */
    computerTurn(checkPossibility) {
        let position;
        // do {
            console.log("Enter the Value");
            position= this.checkWinPosition(checkPossibility)
            console.log(position);
            switch (position) {
                case 1: if (checkPossibility["board"][0][0] == 'X' || checkPossibility["board"][0][0] == 'O') {
                    this.computerTurn(checkPossibility);
                }
                else {
                    console.log("1111");
                    checkPossibility["board"][0][0] = 'O';
                    checkPossibility["countO"]["count1"]++;
                    checkPossibility["countO"]["count4"]++;
                    checkPossibility["countO"]["count7"]++;
                }
                    break;
                case 2: if (checkPossibility["board"][0][1] == 'X' || checkPossibility["board"][0][1] == 'O') {
                    this.computerTurn(checkPossibility);
                }
                else {
                    checkPossibility["board"][0][1] = 'O';
                    checkPossibility["countO"]["count5"]++;
                    checkPossibility["countO"]["count1"]++;
                }
                    break;
                case 3: if (checkPossibility["board"][0][2] == 'X' || checkPossibility["board"][0][2] == 'O') {
                    this.computerTurn(checkPossibility);
                }
                else {
                    checkPossibility["board"][0][2] = 'O';
                    checkPossibility["countO"]["count1"]++;
                    checkPossibility["countO"]["count6"]++;
                    checkPossibility["countO"]["count8"]++;
                }
                    break;
                case 4:
                    if (checkPossibility["board"][1][0] == 'X' || checkPossibility["board"][1][0] == 'O') {
                        this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][0] = 'O';
                        checkPossibility["countO"]["count2"]++;
                        checkPossibility["countO"]["count4"]++;
                    }
                    break;
                case 5:
                    if (checkPossibility["board"][1][1] == 'X' || checkPossibility["board"][1][1] == 'O') {
                        this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][1] = 'O';
                        checkPossibility["countO"]["count5"]++;
                        checkPossibility["countO"]["count2"]++;
                        checkPossibility["countO"]["count7"]++;
                        checkPossibility["countO"]["count8"]++;
                    }
                    break;
                case 6:
                    if (checkPossibility["board"][1][2] == 'X' || checkPossibility["board"][1][2] == 'O') {
                        this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][1][2] = 'O';
                        checkPossibility["countO"]["count6"]++;
                        checkPossibility["countO"]["count2"]++;
                    }
                    break;
                case 7:
                    if (checkPossibility["board"][2][0] == 'X' || checkPossibility["board"][2][0] == 'O') {
                        this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][0] = 'O';
                        checkPossibility["countO"]["count3"]++;
                        checkPossibility["countO"]["count4"]++;
                        checkPossibility["countO"]["count8"]++;
                    }
                    break;
                case 8:
                    if (checkPossibility["board"][2][1] == 'X' || checkPossibility["board"][2][1] == 'O') {
                        this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][1] = 'O';
                        checkPossibility["countO"]["count3"]++;
                        checkPossibility["countO"]["count5"]++;
                    }
                    break;
                case 9: if (checkPossibility["board"][2][2] == 'X' || checkPossibility["board"][2][2] == 'O') {
                    this.computerTurn(checkPossibility);
                    }
                    else {
                        checkPossibility["board"][2][2] = 'O';
                        checkPossibility["countO"]["count6"]++;
                        checkPossibility["countO"]["count3"]++;
                        checkPossibility["countO"]["count7"]++;
                    }
                    break;
               }
        // } while (position < 1 || position > 9);
        return checkPossibility;
    },
    /**
     * computer return win position if available otherwise give random number between 1 to 9
     */
    checkWinPosition(checkPossibility){
        if(checkPossibility["countX"]["count1"]==2)
        {
            if(checkPossibility["board"][0][0]!='X')
                return 1;
            else if(checkPossibility["board"][0][1]!='X')
                return 2;
            else if(checkPossibility["board"][0][3]!='X')
                return 3;
        }else if(checkPossibility["countX"]["count2"]==2)
        {
            if(checkPossibility["board"][1][0]!='X')
                return 4;
            else if(checkPossibility["board"][1][1]!='X')
                return 5;
            else if(checkPossibility["board"][1][3]!='X')
                return 6;
        }else if(checkPossibility["countX"]["count3"]==2)
        {
            if(checkPossibility["board"][2][0]!='X')
                return 7;
            else if(checkPossibility["board"][2][1]!='X')
                return 8;
            else if(checkPossibility["board"][2][3]!='X')
                return 9;
        }
        else if(checkPossibility["countX"]["count4"]==2)
        {
            if(checkPossibility["board"][0][0]!='X')
                return 1;
            else if(checkPossibility["board"][1][0]!='X')
                return 4;
            else if(checkPossibility["board"][2][0]!='X')
                return 7;
        }
        else if(checkPossibility["countX"]["count5"]==2)
        {
            if(checkPossibility["board"][0][1]!='X')
                return 2;
            else if(checkPossibility["board"][1][1]!='X')
                return 5;
            else if(checkPossibility["board"][2][1]!='X')
                return 8;
        }else if(checkPossibility["countX"]["count6"]==2)
        {
            if(checkPossibility["board"][0][2]!='X')
                return 3;
            else if(checkPossibility["board"][1][2]!='X')
                return 6;
            else if(checkPossibility["board"][2][2]!='X')
                return 9;
        }else if(checkPossibility["countX"]["count7"]==2)
        {
            if(checkPossibility["board"][0][0]!='X')
                return 1;
            else if(checkPossibility["board"][1][1]!='X')
                return 5;
            else if(checkPossibility["board"][2][2]!='X')
                return 9;
        }else if(checkPossibility["countX"]["count8"]==2)
        {
            if(checkPossibility["board"][2][0]!='X')
                return 7;
            else if(checkPossibility["board"][1][1]!='X')
                return 5;
            else if(checkPossibility["board"][0][2]!='X')
                return 3;
        }
        else
        {
            return ((Math.floor(Math.random() * 9))+1); 
        }
    },
    /**
     * check tic-tac-toe winner
     */
    checkWinner(checkPossibility){
        let win=[false,false];
        if(checkPossibility["countX"][0]==3||checkPossibility["countX"][1]==3||checkPossibility["countX"][2]==3||checkPossibility["countX"][3]==3||checkPossibility["countX"][4]==3||checkPossibility["countX"][5]==3||checkPossibility["countX"][6]==3||checkPossibility["countX"][7]==3)
            win[0]=true;
        else if(checkPossibility["countO"][0]==3||checkPossibility["countO"][1]==3||checkPossibility["countO"][2]==3||checkPossibility["countO"][3]==3||checkPossibility["countO"][4]==3||checkPossibility["countO"][5]==3||checkPossibility["countO"][6]==3||checkPossibility["countO"][7]==3)
            win[1]=true;

            return win;
    }


}
