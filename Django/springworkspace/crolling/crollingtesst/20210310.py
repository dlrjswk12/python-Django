import urllib.request
from bs4 import BeautifulSoup
import requests

req = requests.get("https://blog.naver.com/cdh0584/222268133196")
#print(req)
qqq= req.text
#print(qqq)

soup = BeautifulSoup(req.content, "html.parser")

#print(soup)

qq=soup.find_all('meta')

print(qq)


