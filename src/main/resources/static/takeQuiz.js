"use strict";
    var aswr;

    document.addEventListener("DOMContentLoaded", function() {
        getRandomQuiz();
    });

    function checkAnswer(event) {
        event.preventDefault();
        var qf = document.getElementById("quizform");
        var checked = qf.querySelector('input[name=answer]:checked').id;
        var resBtn = document.getElementById("check-res-btn");
        var optionR = {1: 'ans1-label', 2: 'ans2-label', 3: 'ans3-label', 4: 'ans4-label'};
        var optionT = {'ans1': 'ans1-label', 'ans2': 'ans2-label', 'ans3': 'ans3-label', 'ans4': 'ans4-label'};
        
        // if (document.getElementById(checked) == option[aswr]) {
        if (optionT[checked] == optionR[aswr]) {
            resBtn.classList.replace('btn-base', 'res-btn-answer');
            resBtn.className += ' px-11';
            resBtn.innerText = '정답';
        } else {
            document.getElementById(optionT[checked]).className += ' res-wrong';
            // console.log(document.getElementById(optionT[checked]).className);
            document.getElementById(checked).checked = false;
            document.getElementById(optionR[aswr]).className += ' res-answer';
            // console.log(document.getElementById(optionR[aswr]).className);
            resBtn.classList.replace('btn-base', 'res-btn-wrong');
            resBtn.className += ' px-11';
            resBtn.innerText = '오답';
        } 
        resBtn.disabled = true;
        document.getElementById("ans1").disabled = true;
        document.getElementById("ans2").disabled = true;
        document.getElementById("ans3").disabled = true;
        document.getElementById("ans4").disabled = true;

        console.log(checked);
    }

    function nextQuestion() {
        window.location.reload();
    }

    function getRandomQuiz() {
        var c1;
        var c2;
        var c3;
        var c4;
        var ctxt;

        fetch('http://localhost:8080/topik/getRandom', {
            method: "GET",
        }).then(response => {
            return response.json();
        }).then (jsonData => {
            console.log(jsonData);
            c1 = jsonData.choice1;
            c2 = jsonData.choice2;
            c3 = jsonData.choice3;
            c4 = jsonData.choice4;
            ctxt = jsonData.context;
            aswr = jsonData.answer;

            document.getElementById('ans1_txt').innerHTML = c1;
            document.getElementById('ans2_txt').innerHTML = c2;
            document.getElementById('ans3_txt').innerHTML = c3;
            document.getElementById('ans4_txt').innerHTML = c4;
            document.getElementById('question-context').innerHTML = ctxt;

        }). catch(err => {console.log(err);})
    }