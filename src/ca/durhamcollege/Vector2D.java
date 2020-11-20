package ca.durhamcollege;

public class Vector2D
{
    // Private Instance Variables
    private float x;
    private float y;

    // Public Properties (Mutators & Accessors)

    public float getX()
    {
        return x;
    }

    public void setX(final float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(final float y)
    {
        this.y = y;
    }

    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
    }

    public void set(final Vector2D vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    // Constructors

    Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }

    Vector2D(final float x, final float y)
    {
        set(x,y);
    }

    Vector2D(final Vector2D vector)
    {
        set(vector.getX(), vector.getY());
    }

    // Private Methods


    // Public Methods

    public void add(final Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }

    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
    }

    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }

    public void divide(final Vector2D rhs)
    {
        if (rhs.getX() != 0 && rhs.getY() != 0)
        {
            this.setX(this.getX() / rhs.getX());
            this.setY(this.getY() / rhs.getY());
        }
    }

    public boolean equals(final Vector2D rhs)
    {
        return ((this.getX() == rhs.getX()) && (this.getY() == rhs.getY()));
    }

    public float getMagnitude()
    {
        return (float)Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY());
    }

    public float getSqrMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY());
    }

    public void setScale(final float scale)
    {
        this.set(this.getX() * scale, this.getY() * scale);
    }

    public void setScale(final Vector2D scale)
    {
        this.set(this.getX() * scale.getX(), this.getY() * scale.getY());
    }

    public void divideScale(final float scale)
    {
        if (scale != 0)
        {
            this.set(this.getX() / scale, this.getY() / scale);
        }
    }

    public void normalize()
    {
        final var magnitude = this.getMagnitude();

        if (magnitude > 9.99999974737875E-06)
        {
            set(getX() / magnitude, getY() / magnitude);
        }
        else
        {
            set(zero());
        }
    }

    public Vector2D getNormalized()
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }


    // Static Methods

    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }

    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }

    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }

    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }

    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        if (t < 0.0f)
            t = 0.0f;
        else if (t > 1.0f)
            t = 1.0f;

        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    public static Vector2D lerpUnclamped(final Vector2D a, final Vector2D b, final float t)
    {
        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    public static Vector2D moveTowards(final Vector2D current, final Vector2D target, final float max_distance_delta)
    {
        var vector = new Vector2D(target);
        vector.subtract(current);
        final var magnitude = vector.getMagnitude();

        if (magnitude <= max_distance_delta || magnitude == 0.0f)
        {
            return target;
        }

        vector.add(current);
        vector.divideScale(magnitude * max_distance_delta);
        return vector;
    }

    public static Vector2D scale(final Vector2D a, final Vector2D b)
    {
        return new Vector2D(a.getX() * b.getY(), a.getY() * b.getY());
    }

    public static Vector2D reflect(final Vector2D in_direction, final Vector2D in_normal)
    {
        var vector = new Vector2D(in_normal);
        vector.setScale(-2.0f * dot(vector, in_direction));
        vector.add(in_direction);

        return vector;
    }

    public static Vector2D perpendicular(final Vector2D in_direction)
    {
        return new Vector2D(-in_direction.getY(), in_direction.getX());
    }

    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    public static float angle(final Vector2D from, final Vector2D to)
    {
        final var denominator = (float)Math.sqrt(from.getSqrMagnitude() * to.getSqrMagnitude());
        if (denominator < 1e-15f)
        {
            return 0.0f;
        }

        float dot = dot(from, to) / denominator;

        if (dot < -1.0f)
            dot = -1.0f;
        else if (dot > 1.0f)
            dot = 1.0f;

        return (float)(Math.acos(dot) * 57.9578f);
    }

    public static float signedAngle(final Vector2D from, final Vector2D to)
    {
        final var unsigned_angle = angle(from, to);
        final var number = from.getX() * to.getY() - from.getY() * to.getX();
        final float sign;
        if (number >= 0.0f)
            sign = 1.0f;
        else
            sign = -1.0f;

        return unsigned_angle * sign;
    }

    public static float distance(final Vector2D a, final Vector2D b)
    {
        final var delta_x = b.getX() - a.getX();
        final var delta_y = b.getY() - a.getY();

        return (float)Math.sqrt(delta_x * delta_x + delta_y * delta_y);
    }

    public static Vector2D clampMagnitude(final Vector2D vector, float max_length)
    {
        if (vector.getSqrMagnitude() > max_length * max_length)
        {
            final var normalized = vector.getNormalized();
            normalized.setScale(max_length);
            return normalized;
        }

        return vector;
    }

    public static float sqrMagnitude(final Vector2D a)
    {
        return (float)((double)(a.getX()) * (double)(a.getX()) + (double)(a.getY()) * (double)(a.getY()));
    }

    public static Vector2D min(final Vector2D lhs, final Vector2D rhs)
    {
        return new Vector2D(Math.min(lhs.getX(), rhs.getX()), Math.min(lhs.getY(), rhs.getY()));
    }

    public static Vector2D max(final Vector2D lhs, final Vector2D rhs)
    {
        return new Vector2D(Math.max(lhs.getX(), rhs.getX()), Math.max(lhs.getY(), rhs.getY()));
    }

}
