
#########################
## SANAKIRJA EXTRACTOR ##
#########################

# the script I used to download and format the dictionary

#imports
import urllib.request
import zipfile
import os
import shutil
from xml.etree import ElementTree as ET

# url to dictionary package
source_url = 'http://kaino.kotus.fi/sanat/nykysuomi/kotus-sanalista-v1.zip'

# download zipfile from url
urllib.request.urlretrieve(source_url, 'sanalista.zip')

# extract zipfile
with zipfile.ZipFile('sanalista.zip', 'r') as z:
    z.extractall('downloads/')

# initialize new file
f = open('sanalista.txt', 'a')

# extract word list from the file
file_name = 'kotus-sanalista_v1.xml'
full_file = os.path.join('downloads/kotus-sanalista_v1/', file_name)
tree = ET.parse(full_file)
root = tree.getroot()

# write words only to new file
for child in root:
    f.write(child[0].text + '\n' )

if os.path.exists('sanalista.zip'):
  os.remove('sanalista.zip')
else:
  print('The file does not exist') 

if os.path.exists('downloads/'):
  shutil.rmtree('downloads/')
else:
  print('The file does not exist') 

f.close()

