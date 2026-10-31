import random
numbers = []
n = 100
attempts = 10
score = 0
def rules ():
    print("\n" + "GuessNumber game in python ...2023..." + "\n")
    print("you only get 10 attempts, if you guess the number then you will get " +
        "3 more attemtps to guess the next number.")
    print("when you take your guess and it is not the number your score decreases by 5.")
    print("The game ends when you run out of attempts.")
    print("\n"+ "Good Luck!")
rules()
# generates random number with a list size of 100
# generates a number between 0-100
for i in range(n):
    numbers.append(random.randint(0,100))
    theNumber = random.choice(numbers)
print("\n")
def scoreBoard (score):
    print("\n" + "Your Score Is...")
    if score >= 600 and score <= 1000:
        print("Insane: 600-1000")
    elif score >= 400 and score <= 599:
        print("Above average: 400-599")
    elif score >= 200 and score <= 399:
        print("Average: 200-399")
    elif score >= 100 and score <= 199:
        print("Almost failing: 100-199")
    elif score >=30 and score <=99:
        print("failing: 30-99")
    else:
        print("You are not in any category")
while True:
    print("Guess a Number between 0-100 ... " + str(attempts) + " attempts")
    guess1 = int(input(""))
    if guess1 > theNumber:
        score = score - 5
        attempts = attempts - 1
        print("\n")
        print("Guess Lower than "+ str(guess1))
    elif guess1 < theNumber:
        score = score - 5
        attempts = attempts - 1
        print("\n")
        print ("Guess Higher than " + str(guess1))
    if guess1 == theNumber:
        theNumber = random.choice(numbers)
        attempts = attempts + 3
        score = score + 100
        print("\n")
        print("You Have Guessed the Number Correct! Your Score Is: " + str(score))
    elif attempts == 0:
        print("You Ran Out Of Attempts Your Score Is: "+ str(score) +
        " The number was: " + str(theNumber))
        scoreBoard(score)
    exit()
