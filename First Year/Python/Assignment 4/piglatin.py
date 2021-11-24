#Modules of translate main thread to piglatin or english
#Richmond Arthur
#8 April 2018

def to_english(sentence):
    words=sentence.split()
    new_sentence=''
    for word in words:
        so=len(word)
        do=so-3
        lo=so-2
        ko=so-1
        if word[do:so:]=='way':
            word=word[0:do]

        elif word[lo:so]=='ay':
            word=word[0:lo]
            #print(word)
            a=len(word)-1
            while word[-1]!='a':
                #print(word)
                word=word[-1]+word[0:a]
            b=len(word)-1
            word=word[0:b]            
        new_sentence=new_sentence+word+' '
    return new_sentence
    #print(new_sentence)
def to_pig_latin(sentence):
    words=sentence.split()
    new_sentence=''
    for word in words:
        if word[0] in 'aeiou':
            word=word+'way' 
        else:
            word=word+'a'
            for i in range(0,6):
                if word[0] not in'aeiou':
                    word=word[1:]+word[0]
            word=word+'ay'
        new_sentence = new_sentence+word+ ' '
        
    return new_sentence
    #print(new_sentence)
to_english("abbbbay")
to_pig_latin("a")
