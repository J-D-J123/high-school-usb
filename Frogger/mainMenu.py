import pygame

# sets all the variables up
background_color = (255, 255, 255)
(width, height) = (300, 300)

# sets up the toolbar
class Window(QMainWindow):
    def createMenuBar(self):
        menuBar = self.menuBar()
        # menu object
        playMenu = QMenu("&Play", self)
        menuBar.addMenu(playMenu)

# sets up the screen with the background color
screen = pygame.display.set_mode((width, height))
screen.fill(background_color)
pygame.display.flip()

pygame.display.set_caption('Frogger 1.1')
# display = pygame.display.set_mode((500, 400))  # window size is determined here
pygame.init()
character = pygame.image.load("png/frog.png")
background = pygame.image.load("png/background.png")
characterx = 0
charactery = 0

# code for score
# dont forget to update the score...

# code to run the frog

# code for user input to the frog

# code for the road

# code for the cars

# if frog dies then show "GAME OVER"
# and show score variable
# add two buttons that say "restart" or "exit"


# if game runs do not close
# if game ends close
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
