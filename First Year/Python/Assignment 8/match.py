def find(pattern):
    if pattern=='':
        return 
    if pattern[0]=='?':
        return 0
    return 1+find(pattern[1:])

def revchop(word,pattern):
    if word=='':
        return False
    if word[-1]==pattern[-1]:
        return revchop(pattern[:-1],word[:-1])
    if pattern[-1]=='?':
        return True
    
def match(word,pattern):
    a=find(pattern)
    if len(word)!=len(pattern):
        return False
    if word=='' and pattern=='':
        return True
    if pattern[a]=='?':
        if revchop(word,pattern)==True:
            return True
    return match(word[1:],pattern[1:])
pattern=input('Enter a pattern (or \'q\' to quit): \n')
word=input('Enter a word: \n')
if match(word,pattern)==True:
    print('It\'s a match.')
else:
    print('They don\'t match.')
