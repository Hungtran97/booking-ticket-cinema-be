# Sử dụng image Maven để build ứng dụng
FROM maven:3-eclipse-temurin-21 AS builder

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . /app

# Đặt quyền truy cập root để có thể thực hiện các lệnh yêu cầu quyền cao
USER root

# Đặt các biến môi trường từ ARG (nếu cần thiết)
ARG SERVER_PORT
ARG MYSQL_ROOT_PASSWORD
ARG MYSQL_ROOT_USERNAME
ARG MYSQL_DATABASE
ARG MYSQL_URL
ARG R2_ACCESS_KEY
ARG R2_SECRET_KEY
ARG R2_REGION
ARG R2_ENDPOINT
ARG R2_BUCKET
ARG R2_PUBLIC_PATH
ARG OPEN_API_TITLE
ARG OPEN_API_VERSION
ARG OPEN_API_DESCRIPTION
ARG OPEN_API_SERVER_URL
ARG OPEN_API_SERVER_NAME

# Tạo tệp .env.properties từ các biến môi trường
RUN echo "SERVER_PORT=${SERVER_PORT}" > /app/.env.properties
RUN echo "MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD}" >> /app/.env.properties
RUN echo "MYSQL_ROOT_USERNAME=${MYSQL_ROOT_USERNAME}" >> /app/.env.properties
RUN echo "MYSQL_DATABASE=${MYSQL_DATABASE}" >> /app/.env.properties
RUN echo "MYSQL_URL=${MYSQL_URL}" >> /app/.env.properties
RUN echo "R2_ACCESS_KEY=${R2_ACCESS_KEY}" >> /app/.env.properties
RUN echo "R2_SECRET_KEY=${R2_SECRET_KEY}" >> /app/.env.properties
RUN echo "R2_REGION=${R2_REGION}" >> /app/.env.properties
RUN echo "R2_ENDPOINT=${R2_ENDPOINT}" >> /app/.env.properties
RUN echo "R2_BUCKET=${R2_BUCKET}" >> /app/.env.properties
RUN echo "R2_PUBLIC_PATH=${R2_PUBLIC_PATH}" >> /app/.env.properties
RUN echo "OPEN_API_TITLE=${OPEN_API_TITLE}" >> /app/.env.properties
RUN echo "OPEN_API_VERSION=${OPEN_API_VERSION}" >> /app/.env.properties
RUN echo "OPEN_API_DESCRIPTION=${OPEN_API_DESCRIPTION}" >> /app/.env.properties
RUN echo "OPEN_API_SERVER_URL=${OPEN_API_SERVER_URL}" >> /app/.env.properties
RUN echo "OPEN_API_SERVER_NAME=${OPEN_API_SERVER_NAME}" >> /app/.env.properties

# Build ứng dụng bằng Maven
RUN mvn clean package -Prender -DskipTests

# Sử dụng image Java để chạy ứng dụng
FROM eclipse-temurin:21-jdk-alpine

# Copy tệp JAR đã build từ builder image vào container
COPY --from=builder /app/target/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar /app/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar

# Xóa tệp .env.properties sau khi build
RUN rm -f /app/.env.properties
# Mở cổng 8080 cho ứng dụng
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar"]
