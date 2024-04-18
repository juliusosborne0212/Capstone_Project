import axios from "axios";

let words = axios.get(); //Need the route to the api

let word = [];
word.push(words.data);

let score = 0;

let hangmanWord = word[Math.floor(Math.random() * 21)];

function inputDashes(){
    for(let letter in hangmanWord){
        document.querySelector().innerHTML = `_`;
        }
}

function userInput(){
    document.querySelector().addEventListener("submit", event => {
        event.preventDefault();
        let input = event.target.elements;
    })
    return input;
}

function playGame(){
    inputDashes();
    let incorrectGuess = 6;
    let guessCount = 0;
    let tries = 0;
    let input = userInput()
    while (guessCount < incorrectGuess){
        for (let letter in hangmanWord){
            if (input.toLowerCase() == letter.toLowerCase()){
                document.querySelector().innerHTML = `${input}`;
                tries++;
            } else if (input.toLowerCase() !== letter.toLowerCase()) {
                // make part of the body visible
                guessCount++;
                tries++;
            }
        }
    }

    if (guessCount === incorrectGuess){
        // make user input for initials
        // score based off of how many tries it took
    }
}