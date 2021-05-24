'''3월 10일 과제
Created on 2021. 3. 10.


오래된 자료라서 class 가 없다 
@author: pc353
'''

import urllib.request
from bs4 import BeautifulSoup

url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC"
html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html,'html.parser')



title = soup.find_all(class_="")
#print(title)
#print(len(title))

for i in title:
    print(i.attrs['href'])

