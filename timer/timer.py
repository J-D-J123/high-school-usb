import time
import sys
import pygame
import pyttsx3
import speech_recognition as sr

# start timerCount at 0 then at the start of every timer update it by one
timerCount = 0
breakCount = 0


def initialize_tts():
    engine = pyttsx3.init()
    return engine


def start_timer(duration):
    global timerCount  # Declare timerCount as global
    timerCount = timerCount + 1
    text_to_speech_engine = initialize_tts()
    text_to_speech_engine.say("Starting timer")
    text_to_speech_engine.runAndWait()

    seconds = duration * 60  # Convert minutes to seconds
    print(f"Timer set for {duration} minutes.")

    for remaining_seconds in range(seconds, 0, -1):
        minutes, secs = divmod(remaining_seconds, 60)
        time_str = f"Time remaining: {minutes:02d} minutes and {secs:02d} seconds"
        sys.stdout.write('\033[K')  # Clear the line
        sys.stdout.write(time_str)
        sys.stdout.flush()
        sys.stdout.write("\n")
        time.sleep(1)

    print("\nTimer complete!")
    text_to_speech_engine.say("Timer complete!")
    play_alert_sound()
    text_to_speech_engine.runAndWait()

    take_a_break()


def play_alert_sound():
    pygame.mixer.init()
    pygame.mixer.music.load("alert_sound.mp3")
    pygame.mixer.music.play()
    time.sleep(5)  # Allow time for the sound to play (adjust as needed)


def get_user_response():
    recognizer = sr.Recognizer()

    with sr.Microphone() as source:
        audio = recognizer.listen(source)
        print("Say 'yes' or 'no'")

    try:
        user_response = recognizer.recognize_google(audio).lower()
        print(f"user said: {user_response}")
        return user_response
    except sr.UnknownValueError:
        print("Sorry, I didn't catch that. Please try again.")
        return get_user_response()
    except sr.RequestError as e:
        print(f"Could not request results from Speech Recognition service; {e}")
        return None


def next_timer():
    global timerCount  # Declare timerCount as global
    text_to_speech_engine = initialize_tts()
    text_to_speech_engine.say("Do you want to set a timer? Say 'yes' or 'no'.")
    text_to_speech_engine.runAndWait()

    print("Say 'yes' or 'no'")
    user_input = get_user_response()

    if user_input and "yes" in user_input:
        timerCount = timerCount + 1
        start_timer(30)
    else:
        text_to_speech_engine.say("No input recognized.")

    if user_input and "no" in user_input:
        text_to_speech_engine.say(f"You used {timerCount} timers, have a nice day.")
        print(f"You used {timerCount} study timers, have a nice day.")
    else:
        text_to_speech_engine.say("No input recognized.")


def take_a_break():
    # global timerCount  # Declare timerCount as global
    text_to_speech_engine = initialize_tts()
    text_to_speech_engine.say("Do you want to take a 10-minute break? Say 'yes' or 'no'.")
    text_to_speech_engine.runAndWait()

    user_input = get_user_response()

    if user_input and "yes" in user_input:
        rest_for(10)
        next_timer()

    else:
        text_to_speech_engine.say("No input recognized.")

    if user_input and "no" in user_input:
        text_to_speech_engine.say(f"You have used {timerCount} study timers.")
        print(f"You have used{timerCount}study timers.")


def rest_for(n):
    text_to_speech_engine = initialize_tts()
    text_to_speech_engine.say("Starting break")
    text_to_speech_engine.runAndWait()

    seconds = n * 60  # Convert minutes to seconds

    for remaining_seconds in range(seconds, 0, -1):
        minutes, secs = divmod(remaining_seconds, 60)
        time_str = f"Time remaining: {minutes:02d} minutes and {secs:02d} seconds"
        sys.stdout.write('\033[K')  # Clear the line
        sys.stdout.write(time_str)
        sys.stdout.flush()
        sys.stdout.write("\n")
        time.sleep(1)

    print("\nTimer complete!")
    text_to_speech_engine.say("Timer complete!")
    text_to_speech_engine.runAndWait()


def main():
    next_timer()


if __name__ == '__main__':
    main()
