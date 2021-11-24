def prevnum(n,m):
    if n==1:
        return True
    if m%n==0:
        return False
        #if n!=n: return False
    return prevnum(n-1,m)
