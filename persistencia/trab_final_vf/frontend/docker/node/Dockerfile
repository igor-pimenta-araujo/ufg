FROM node:6.9.0
 WORKDIR /var/www
 
 COPY ./package.json ./package-lock.json ./
 RUN npm install --progress=silent

 COPY ./public/ ./public/
 EXPOSE 8888
 CMD sh -c "while true; do sleep 100; done"