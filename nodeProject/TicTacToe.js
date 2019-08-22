const utility=require("./Utility/Utility");
TicTacToe=()=>
{
    let board=[['1','2','3'],['4','5','6'],['7','8','9']];
    let countX={"count1":0,"count2":0,"count3":0,"count4":0,"count5":0,"count6":0,"count7":0,"count8":0};
    let countO={"count1":0,"count2":0,"count3":0,"count4":0,"count5":0,"count6":0,"count7":0,"count8":0};
    let count=0;
    let win=[false,false];
    let checkPossiblity={"board":board,"countX":countX,"countO":countO};
    
      
    do{
        utility.displayBoard(checkPossiblity["board"]);
        if(count==9)
            break;
        console.log("User Turn");
        checkPossiblity=utility.userTurn(checkPossiblity);
        count++;
        win=utility.checkWinner(checkPossiblity);
        if(win[0]==true)
        {
            console.log("User Won Game");
            break;
        }
        utility.displayBoard(checkPossiblity["board"]);  
        console.log(checkPossiblity["countX"]);
        if(count==9)
            break;
        console.log("Computer Turn");    
        checkPossiblity=utility.computerTurn(checkPossiblity);
        count++;
        win=utility.checkWinner(checkPossiblity);
        if(win[1]==true)
        {
            console.log("Computer Won Game");
            break;
        }

    }while(count!=9);
    if(win[0]==false && win[1]==false)
        console.log("Match draw");


}


module.exports = TicTacToe();