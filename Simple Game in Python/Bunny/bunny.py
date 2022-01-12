import sys

sys.path.append("c:/users/user/appdata/roaming/python/python39/site-packages")

# 1 - Import library
import pygame
from pygame.locals import *
import math
import random


# 2 - Initialize the game
pygame.init()
width, height = 640, 480
screen=pygame.display.set_mode((width, height))
player_size = (80,80)
castle_size = (100,100)
#screen_size = (10, 10)
keys = [False, False, False, False]
playerpos=[100,100]
displacement = 2 #How much the player will move in a direction
acc=[0,0] #Keeps track of the number of arrows shot and the number that hit ther target. Used to calculate shooting accuracy
arrows=[] #Stores the direction of the arrows shot, all arrows off the board will be removed from the array
arrow_size = [40,20]
arrow_speed = 3
#badger
badtimer=150
badtimer1=0
badguys=[[640,100]]
badger_speed = 0.5
badger_size = [60,60]
#Health
healthvalue=194


# 3 - Load images
player = pygame.image.load("resources/images/bunny3.png")
player = pygame.transform.scale(player, player_size)
player = pygame.transform.flip(player, True, False) #The issue here is that the we need the image to change direction when the mouse is at a certain angle or the image is upside down
grass = pygame.image.load("resources/images/background1.jpg")
#grass = pygame.transform.scale(grass, screen_size)
castle = pygame.image.load("resources/images/castle2.png")
castle = pygame.transform.scale(castle, castle_size)
arrow = pygame.image.load("resources/images/arrow6.png")
arrow = pygame.transform.scale(arrow, arrow_size)
badguyimg1 = pygame.image.load("resources/images/badger4.png")
badguyimg1 = pygame.transform.scale(badguyimg1, badger_size)
badguyimg=badguyimg1



# 4 - keep looping through
# 4 - keep looping through
running = 1
exitcode = 0
while running:
    badtimer-=1

    # 5 - clear the screen before drawing it again
    screen.fill(0)
    for x in range(width//grass.get_width()+3):
        for y in range(height//grass.get_height()+2):
            screen.blit(grass,(x*100,y*100))
    screen.blit(castle,(0,30))
    screen.blit(castle,(0,135))
    screen.blit(castle,(0,240))
    screen.blit(castle,(0,345))
    # 6 - draw the screen elements
        # 6.1 - Set player position and rotation
    position = pygame.mouse.get_pos()
        #Note that the parameters of math.atan2(y,x) We get the angle between the mouse and the position of the player.
    angle = math.atan2(position[1]-(playerpos[1]+32),position[0]-(playerpos[0]+26))
        #This rotates the player. Note that angle is in radians, so by multiplying by 57.29(360/2*pi) we can convert it to degrees.
    playerrot = pygame.transform.rotate(player, 360-angle*57.29)
        #The player's position changes slightly with rotation
    playerpos1 = (playerpos[0]-playerrot.get_rect().width/2, playerpos[1]-playerrot.get_rect().height/2)
    screen.blit(playerrot, playerpos1)

         # 6.2 - Draw arrows
    for bullet in arrows: 
        index=0
        velx=math.cos(bullet[0])*arrow_speed*(-1)
        vely=math.sin(bullet[0])*arrow_speed*(-1)
        bullet[1]+=(velx * -1) #-1 simply changes the direction the arrows travel
        bullet[2]+=(vely * -1)
        if bullet[1]<-64 or bullet[1]>640 or bullet[2]<-64 or bullet[2]>480:
            arrows.pop(index)
        index+=1
        for projectile in arrows:
            arrow1 = pygame.transform.rotate(arrow, 360-projectile[0]*57.29)
            screen.blit(arrow1, (projectile[1], projectile[2]))

        # 6.3 - Draw badgers
    if badtimer==0:
        badguys.append([640, random.randint(50,430)])
        badtimer=100-(badtimer1*1.05)
        if badtimer1>=75:
            badtimer1=75
        else:
            badtimer1+=5
    index=0
    for badguy in badguys:
        if badguy[0]<-64:
            badguys.pop(index)
        badguy[0]-=badger_speed
        index+=1
         # 6.3.1 - Attack castle
        badrect=pygame.Rect(badguyimg.get_rect())
        badrect.top=badguy[1]
        badrect.left=badguy[0]
        if badrect.left<64:
            healthvalue -= random.randint(5,20)
            badguys.pop(index)
        #6.3.2 - Check for collisions
        index1=0
        for bullet in arrows:
            bullrect=pygame.Rect(arrow.get_rect())
            bullrect.left=bullet[1]
            bullrect.top=bullet[2]
            if badrect.colliderect(bullrect):
                acc[0]+=1
                badguys.pop(index)
                arrows.pop(index1)
            index1+=1

        # 6.3.3 - Next bad guy
    for badguy in badguys:
        screen.blit(badguyimg, badguy)

    # 6.4 - Draw clock
    font = pygame.font.Font(None, 24)
    survivedtext = font.render(str((90000-pygame.time.get_ticks())/60000)+":"+str((90000-pygame.time.get_ticks())/1000%60).zfill(2), True, (0,0,0))
    textRect = survivedtext.get_rect()
    textRect.topright=[635,5]
    screen.blit(survivedtext, textRect)

    
    # 7 - update the screen
    pygame.display.flip()
    # 8 - loop through the events
    for event in pygame.event.get():
        # check if the event is the X button
        if event.type == pygame.KEYDOWN:
            if event.key==K_w:
                keys[0]=True
            elif event.key==K_a:
                keys[1]=True
            elif event.key==K_s:
                keys[2]=True
            elif event.key==K_d:
                keys[3]=True
        if event.type == pygame.KEYUP:
            if event.key==pygame.K_w:
                keys[0]=False
            elif event.key==pygame.K_a:
                keys[1]=False
            elif event.key==pygame.K_s:
                keys[2]=False
            elif event.key==pygame.K_d:
                keys[3]=False

        #When the mouse is clicked, the event is captured and this lines of code are implemented. It Adds an arrow to the acc array, and records the position of the mouse for which the arrow will be sent and stores that in the arrow array
        if event.type==pygame.MOUSEBUTTONDOWN:
            position=pygame.mouse.get_pos()
            acc[1]+=1
            arrows.append([math.atan2(position[1]-(playerpos1[1]+32),position[0]-(playerpos1[0]+26)),playerpos1[0]+32,playerpos1[1]+32])
        #Used to close the game when either the close button is pressed or exit()
        if event.type==pygame.QUIT:
            # if it is quit the game
            pygame.quit() 
            exit(0)
        
     # 9 - Move player
    if keys[0]:
        playerpos[1]-=displacement
    elif keys[2]:
        playerpos[1]+=displacement
    if keys[1]:
        playerpos[0]-=displacement
    elif keys[3]:
        playerpos[0]+=displacement

        #10 - Win/Lose check
    if pygame.time.get_ticks()>=90000:
        running=0
        exitcode=1
    if healthvalue<=0:
        running=0
        exitcode=0
    if acc[1]!=0:
        accuracy=acc[0]*1.0/acc[1]*100
    else:
        accuracy=0
        
# 11 - Win/lose display        
if exitcode==0:
    pygame.font.init()
    font = pygame.font.Font(None, 24)
    text = font.render("Accuracy: "+str(accuracy)+"%", True, (255,0,0))
    textRect = text.get_rect()
    textRect.centerx = screen.get_rect().centerx
    textRect.centery = screen.get_rect().centery+24
    screen.blit(gameover, (0,0))
    screen.blit(text, textRect)
else:
    pygame.font.init()
    font = pygame.font.Font(None, 24)
    text = font.render("Accuracy: "+str(accuracy)+"%", True, (0,255,0))
    textRect = text.get_rect()
    textRect.centerx = screen.get_rect().centerx
    textRect.centery = screen.get_rect().centery+24
    screen.blit(youwin, (0,0))
    screen.blit(text, textRect)
while 1:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            exit(0)
    pygame.display.flip()


