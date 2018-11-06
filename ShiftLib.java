  public class ShiftLib
  {
    public static double PI = Math.PI;
        
            //converts degrees to radians
            float deg2rad(float deg)
            {
                return (float) (deg / 180.f * PI);
            }
            
            //converts radians to degrees
            float rad2deg(float rad)
            {
                return (float) (rad / PI * 180.f);
            }
            
            //raises x to an exponent n, always keeping negative sign
            float expo(float x, int n)
            {
                int sign = n % 2;
                float y = 1;
                for (int i = 1; i <= n; i++)
                {
                    y *= x;
                }
                if(sign == 0 && x < 0.f)
                    return -y;
                return y;
            }
            
            //multiplies x by a scaling factor scale
            float scale(float x, float scale)
            {
                return x * scale;
            }

            //limits x: -lim <= x <= lim
            float limit(float x, float lim)
            {
                if (x > lim)
                    return lim;
                else if (x < -lim)
                    return -lim;
                return x;
            }
            
            //normalizes radians to be >= -PI or <= PI
            float normalizeRad(float normalAngle)
            {
                while(normalAngle > PI)
                    normalAngle -= 2.f*PI;
                
                while(normalAngle < -PI)
                    normalAngle += 2.f*PI;
                
                return normalAngle;
            }
            
            //normalizes radians to be >= -PI or <= PI
            float normalizeDeg(float normalAngle)
            {
                while(normalAngle > 180.f)
                    normalAngle -= 360.f;
                
                while(normalAngle < -180.f)
                    normalAngle += 360.f;
                
                return normalAngle;
            }
        }
    }
}