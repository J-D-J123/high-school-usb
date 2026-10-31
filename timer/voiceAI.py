import time
import speech_recognition as sr
import webbrowser
import pyttsx3
import datetime
import pyaudio

def get_audio_input(r, source, prompt, timeout):
    engine.say(prompt)
    engine.runAndWait()
    audio = r.listen(source, timeout=timeout)
    return audio

def handle_error(error_msg):
    engine.say(error_msg)
    engine.runAndWait()
    print("An error occurred")

def get_current_time():
    current_time = datetime.datetime.now().strftime("%H:%M")
    return current_time

def main():
    r = sr.Recognizer()
    global engine
    engine = pyttsx3.init()
    exit_phrases = ["bye", "have a nice day", "cya"]
    keyword = "jarvis"
    listening_time = 10

    while True:
        with sr.Microphone() as source:
            print("...Listening...")
            audio = get_audio_input(r, source, "How can I help you?", listening_time)

        try:
            text = r.recognize_google(audio).lower()
            if keyword not in text:
                print("Please say 'Jarvis' to initiate a command.")
                continue

            if "hello" in text:
                engine.say("Hi!")
                engine.runAndWait()

            elif "open google" in text:
                engine.say("Opening Google.")
                engine.runAndWait()
                time.sleep(2)  # Adjust the delay as needed
                webbrowser.open("www.google.com")

            # Add more commands as needed

            elif any(phrase in text for phrase in exit_phrases):
                print("Goodbye!")
                break

            else:
                print("Unrecognized command.")
                handle_error("Sorry, I didn't understand that command. Please try again.")

        except sr.UnknownValueError:
            handle_error("Sorry, I didn't catch that.")
            continue
        except sr.RequestError:
            handle_error("Sorry, I couldn't connect to the speech recognition service.")
            continue

    def timerMinutes(minutes):
        seconds = minutes * 60
        for i in range(seconds, 0, -1):
            print(f"Time left: {i} seconds")
            time.sleep(1)

        engine.say(f"{minutes} minute timer is up!")
        engine.runAndWait()
        print(f"{minutes} minute timer is up!")

    if __name__ == "__main__":
        main()