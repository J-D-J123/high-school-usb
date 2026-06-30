import tkinter
import pygame

root = tkinter.Tk()
root.title("Frog 1.5")

# the settings for the canvas config
canvas = tkinter.Canvas(root)

# the roads
canvas.create_rectangle(0, 100, 500, 350, fill="gray")

# config the yellow dots on the road
for x in range(4):
    i = 25
    while i <= 370:
        if i == 371:
            break
        canvas.create_rectangle(i - 5, 150, i + 5, 140, fill="black")
        canvas.create_rectangle(i - 5, 200, i + 5, 190, fill="black")

        canvas.create_rectangle(i - 5, 250, i + 5, 240, fill="yellow")
        canvas.create_rectangle(i - 5, 300, i + 5, 290, fill="yellow")
        i += 20
# canvas.create_rectangle(0,150, 30, 140, fill="yellow")

# river ...
# this rectangle represents the river
canvas.create_rectangle(0, 400, 500, 500, fill="blue")

# create the frog's body
frog = canvas.create_oval(200, 575, 220, 595, fill="green")

# create the frog's eyes
eye_l = canvas.create_oval(190, 470, 195, 475, fill="black")
eye_r = canvas.create_oval(225, 470, 230, 475, fill="black")

# create the frog's mouth
mouth = canvas.create_rectangle(193, 485, 227, 490, fill="black")


# this function is to move the frog
def move_frog(event):
    if event.keysym == "Up":
        canvas.move(frog, 0, -20)
    elif event.keysym == "Left":
        canvas.move(frog, -20, 0)
    elif event.keysym == "Down":
        canvas.move(frog, 0, 20)
    elif event.keysym == "Right":
        canvas.move(frog, 20, 0)


# keybindings
canvas.bind_all("<KeyPress-Up>", move_frog)
canvas.bind_all("<KeyPress-Left>", move_frog)
canvas.bind_all("<KeyPress-Down>", move_frog)
canvas.bind_all("<KeyPress-Right>", move_frog)

# sets the outside barriers and checks to see if the frog is touching them
# if frog touching them it will move the frog
# create the left and right barriers
left_barrier = canvas.create_rectangle(10, 0, 0, 600, fill="black")
right_barrier = canvas.create_rectangle(390, 0, 400, 900, fill="black")


# the barriers for the frog
def check_collision_barriers():
    # get the coordinates of the frog
    frog_coords = canvas.coords(frog)
    # get the coordinates of the barriers
    barrier_left_coords = canvas.coords(left_barrier)
    barrier_right_coords = canvas.coords(right_barrier)
    # check if the frog is touching the barriers
    if ((frog_coords[0] + 20 > barrier_left_coords[0] and frog_coords[0] < barrier_left_coords[2]) and
            (frog_coords[1] + 20 > barrier_left_coords[1] and frog_coords[1] < barrier_left_coords[3])):
        canvas.move(frog, 20, 0)

    if ((frog_coords[0] + 20 > barrier_right_coords[0] and frog_coords[0] < barrier_right_coords[2]) and
            (frog_coords[1] + 20 > barrier_right_coords[1] and frog_coords[1] < barrier_right_coords[3])):
        canvas.move(frog, -20, 0)
    # call the function again after 100 milliseconds
    canvas.after(100, check_collision_barriers)


# call the function to check
check_collision_barriers()

# the car
car1 = canvas.create_rectangle(0, 250, 40, 270, fill="red")
car2 = canvas.create_rectangle(0, 270, 40, 290, fill="red")
car3 = canvas.create_rectangle(0, 300, 40, 320, fill="red")
car4 = canvas.create_rectangle(0, 320, 40, 340, fill="red")


# moving the cars
def move_car1():
    canvas.move(car1, 20, 0)
    if canvas.coords(car1)[0] > 400:
        canvas.move(car1, -480, 0)
    canvas.after(100, move_car1)


def move_car2():
    canvas.move(car2, 10, 0)
    if canvas.coords(car2)[0] > 400:
        canvas.move(car2, -480, 0)
    canvas.after(100, move_car2)


def move_car3():
    canvas.move(car3, 25, 0)
    if canvas.coords(car3)[0] > 400:
        canvas.move(car3, -480, 0)
    canvas.after(100, move_car3)


def move_car4():
    canvas.move(car4, 15, 0)
    if canvas.coords(car4)[0] > 400:
        canvas.move(car4, -480, 0)
    canvas.after(100, move_car4)


# call the methods
move_car1()
move_car2()
move_car3()
move_car4()


# create a function to check if the frog is touching the car
def check_collision_cars():
    # get the coordinates of the frog
    frog_coords = canvas.coords(frog)
    # get the coordinates of the cars
    car1_coords = canvas.coords(car1)
    car2_coords = canvas.coords(car2)
    car3_coords = canvas.coords(car3)
    car4_coords = canvas.coords(car4)
    # check if the frog is touching the cars
    if ((frog_coords[0] + 20 > car1_coords[0] and frog_coords[0] < car1_coords[2]) and
        (frog_coords[1] + 20 > car1_coords[1] and frog_coords[1] < car1_coords[3])) or \
            ((frog_coords[0] + 20 > car2_coords[0] and frog_coords[0] < car2_coords[2]) and
             (frog_coords[1] + 20 > car2_coords[1] and frog_coords[1] < car2_coords[3])) or \
            ((frog_coords[0] + 20 > car3_coords[0] and frog_coords[0] < car3_coords[2]) and
             (frog_coords[1] + 20 > car3_coords[1] and frog_coords[1] < car3_coords[3])) or \
            ((frog_coords[0] + 20 > car4_coords[0] and frog_coords[0] < car4_coords[2]) and
             (frog_coords[1] + 20 > car4_coords[1] and frog_coords[1] < car4_coords[3])):
        # reset the frog's position
        canvas.coords(frog, 200, 475, 220, 495)
    # call the function again after 100 milliseconds
    canvas.after(100, check_collision_cars)


# call the function to check
check_collision_cars()

# the logs
log1 = canvas.create_rectangle(0, 405, 40, 425, fill="brown")
log2 = canvas.create_rectangle(0, 430, 40, 450, fill="brown")
log3 = canvas.create_rectangle(0, 455, 40, 475, fill="brown")
log4 = canvas.create_rectangle(0, 480, 40, 500, fill="brown")

# if frog is touching the log then let frog ride the log


# this function is to restart the game
def restart(quit_button=None, restart_button=None, text1=None):
    canvas.coords(frog, 200, 475, 220, 495)
    text1.destroy()
    quit_button.destroy()
    restart_button.destroy()


#show_text2()

# canvas height dimensions and background color
canvas.config(width=400, height=600)
# root.config(bg="green")
# canvas.bind_all()
canvas.pack()
root.mainloop()
