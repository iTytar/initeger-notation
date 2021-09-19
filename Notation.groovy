DIGITS = "0123456789ABCEF"

def String convert(String str, int fromBase, int toBase) {
    toStr(toInteger(str,fromBase),toBase)    
}

def String toStr(int number, int base) {
    toStr("",number,base).reverse()
}

def String toStr(String result, int number, int base) {
//    println "toStr("+result+","+number+","+base+")..."
    if (number == 0) result 
    else toStr(result + toChar(number%base, base), (int)(number / base), base)
}

def int toInteger(String str, int base) {
    final char[] chars = str.reverse().toCharArray();
    int result = 0;
    for(int i=0;i<chars.length;i++) {
        int d = toDigit(chars[i],base);
        result = result + d * (int)Math.pow(base,i);
    }
    result;
}

def int toInteger(int result, String str, int pos, int base) {
//    println "toInteger("+result+","+str+","+pos+","+base+")..."
    if (str.isEmpty()) result
    else toInteger(result + toDigit(str.take(1) as char,base) * (int)Math.pow(base,pos), str.drop(1), ++pos, base)
}

def char toChar(int d, int base) {
    if (d >= base) throw new IllegalArgumentException("illegal digit '"+d+"' for base '"+base+"'")
    DIGITS.getAt(d);
}

def int toDigit(char ch, int base) {
    i = DIGITS.indexOf(ch as int);
    if (i < 0 || i >= base) throw new IllegalArgumentException("illegal character '"+ch+"' for base '"+base+"'")
    return i
}

assert toChar(0,8)=="0"
assert toChar(12,16)=="C"

assert toDigit('A' as char,16)==10

assert toInteger("123",10)==123
assert toInteger("10",8)==8
assert toInteger("123ABCF",16)==19114958

assert toInteger(0,"123ABCF".reverse(),0,16)==19114958

assert toStr(1234,10)=="1234"
assert toStr(19114958,16)=="123ABCF"

assert convert("19114958",10,16)=="123ABCF"
assert convert("123ABCF",16,10)=="19114958"
