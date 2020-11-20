package ca.durhamcollege;

public class Vector2D
{
    // Private Instance Variables
    private float x;
    private float y;

    // Public Properties (Mutators & Accessors)

    /**
     * @return The value of the x part of the Vector2D object.
     */
    public float getX()
    {
        return x;
    }

    /**
     * Sets the value of the x part of a Vector2D object.
     * @param x The value to set for the x part of the Vector2D object.
     */
    public void setX(final float x)
    {
        this.x = x;
    }

    /**
     * @return The value of the y part of the Vector2D object.
     */
    public float getY()
    {
        return y;
    }

    /**
     * Sets the value of the y part of a Vector2D object.
     * @param y The value to set for the y part of the Vector2D object.
     */
    public void setY(final float y)
    {
        this.y = y;
    }

    /**
     * Sets the x and y parts of a Vector2D object.
     * @param x The value to set for the x part of the Vector2D object.
     * @param y The value to set for the y part of the Vector2D object.
     */
    public void set(final float x, final float y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * Sets the x and y parts of a Vector2D object.
     * @param vector The vector to set this Vector2D object to.
     */
    public void set(final Vector2D vector)
    {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    // Constructors

    /**
     * Default constructor for Vector2D object.
     */
    Vector2D()
    {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructs a Vector2D object with the x and y components specified.
     * @param x The x part of the Vector2D object.
     * @param y The y part of the Vector2D object.
     */
    Vector2D(final float x, final float y)
    {
        set(x,y);
    }

    /**
     * Copy constructor for Vector2D objects.
     * @param vector The vector to be copied.
     */
    Vector2D(final Vector2D vector)
    {
        set(vector.getX(), vector.getY());
    }

    // Private Methods


    // Public Methods

    /**
     * Adds a Vector2D object to the current Vector2D object.
     * @param rhs The vector to add.
     */
    public void add(final Vector2D rhs)
    {
        this.setX(this.getX() + rhs.getX());
        this.setY(this.getY() + rhs.getY());
    }

    /**
     * Subtracts a Vector2D object from the current Vector2D object.
     * @param rhs The vector to subtract.
     */
    public void subtract(final Vector2D rhs)
    {
        this.setX(this.getX() - rhs.getX());
        this.setY(this.getY() - rhs.getY());
    }


    /**
     * Multiplies a Vector2D object with the current Vector2D object.
     * @param rhs The vector to multiply.
     */
    public void multiply(final Vector2D rhs)
    {
        this.setX(this.getX() * rhs.getX());
        this.setY(this.getY() * rhs.getY());
    }


    /**
     * Divides the current Vector2D object by the provided Vector2D object.
     * @param rhs The vector to be the divisor.
     */
    public void divide(final Vector2D rhs)
    {
        if (rhs.getX() != 0 && rhs.getY() != 0)
        {
            this.setX(this.getX() / rhs.getX());
            this.setY(this.getY() / rhs.getY());
        }
    }

    /**
     * Compares the current Vector2D object to the specified Vector.
     * @param rhs The vector to compare the current object with.
     * @return True if the Vector2D objects are equal or false otherwise.
     */
    public boolean equals(final Vector2D rhs)
    {
        return ((this.getX() == rhs.getX()) && (this.getY() == rhs.getY()));
    }

    /**
     * @return The magnitude of the current vector
     */
    public float getMagnitude()
    {
        return (float)Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY());
    }

    /**
     * @return The square magnitude of the current vector
     */
    public float getSqrMagnitude()
    {
        return (this.getX() * this.getX() + this.getY() * this.getY());
    }

    /**
     * Multiplies the current Vector2D by the provided scale.
     * @param scale The scale to multiply the vector by.
     */
    public void setScale(final float scale)
    {
        this.set(this.getX() * scale, this.getY() * scale);
    }

    /**
     * Multiplies the current Vector2D by the provided scale.
     * @param scale The vector to multiply the vector by.
     */
    public void setScale(final Vector2D scale)
    {
        this.set(this.getX() * scale.getX(), this.getY() * scale.getY());
    }

    /**
     * Divides the current Vector2D object by the provided scale.
     * @param scale The scale to divide by.
     */
    public void divideScale(final float scale)
    {
        if (scale != 0)
        {
            this.set(this.getX() / scale, this.getY() / scale);
        }
    }


    /**
     * Normalizes the current vector object.
     */
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

    /**
     * @return A normalized vector from the current object.
     */
    public Vector2D getNormalized()
    {
        Vector2D vector = new Vector2D(getX(), getY());
        vector.normalize();
        return vector;
    }

    /**
     * @return The current Vector2D object formatted as a string.
     */
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }


    // Static Methods

    /**
     * @return A vector object with both components set to 0.0.
     */
    public static Vector2D zero()
    {
        return new Vector2D(0.0f, 0.0f);
    }

    /**
     * @return A vector object with both components set to 1.0.
     */
    public static Vector2D one()
    {
        return new Vector2D(1.0f, 1.0f);
    }

    /**
     * @return A vector object with it's x component set to -1.0.
     */
    public static Vector2D left()
    {
        return new Vector2D(-1.0f, 0.0f);
    }

    /**
     * @return A vector object with it's x component set to 1.0.
     */
    public static Vector2D right()
    {
        return new Vector2D(1.0f, 0.0f);
    }

    /**
     * @return A vector object with it's y component set to 1.0.
     */
    public static Vector2D up()
    {
        return new Vector2D(0.0f, 1.0f);
    }

    /**
     * @return A vector object with it's y component set to -1.0.
     */
    public static Vector2D down()
    {
        return new Vector2D(0.0f, -1.0f);
    }

    /**
     * Linearly Interpolates vectors a and b by t.
     *
     * @param a The vector to interpolate from
     * @param b The vector to interpolate to
     * @param t The value representing how far to interpolate
     * @return A linearly interpolated vector2D object (clamped).
     */
    public static Vector2D lerp(final Vector2D a, final Vector2D b, float t)
    {
        if (t < 0.0f)
            t = 0.0f;
        else if (t > 1.0f)
            t = 1.0f;

        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    /**
     * Linearly interpolates vectors a and b by t.
     *
     * @param a The vector to interpolate from
     * @param b The vector to interpolate to
     * @param t The value representing how far to interpolate
     * @return A linearly interpolated vector2D object (unclamped).
     */
    public static Vector2D lerpUnclamped(final Vector2D a, final Vector2D b, final float t)
    {
        return new Vector2D(a.getX() + (b.getX() - a.getX()) * t, a.getY() + (b.getY() - a.getY()) * t);
    }

    /**
     * Move a point towards a target. (Linear Interpolation with maximum distance)
     * @param current The Vector2D object representing the current position.
     * @param target The Vector2D object representing the target position.
     * @param max_distance_delta The maximum distance (negative values move vector away from target).
     * @return The vector after the move.
     */
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

    /**
     * Multiplies two vectors component-wise.
     * @param a The first vector
     * @param b The second vector
     * @return The vector that is the product of the two vectors.
     */
    public static Vector2D scale(final Vector2D a, final Vector2D b)
    {
        return new Vector2D(a.getX() * b.getY(), a.getY() * b.getY());
    }

    /**
     * Reflects a vector off another vector defined by a normal.
     * @param in_direction The vector to reflect.
     * @param in_normal The normal.
     * @return The vector after the reflect.
     */
    public static Vector2D reflect(final Vector2D in_direction, final Vector2D in_normal)
    {
        var vector = new Vector2D(in_normal);
        vector.setScale(-2.0f * dot(vector, in_direction));
        vector.add(in_direction);

        return vector;
    }

    /**
     * Returns the vector perpendicular to a vector.
     * @param in_direction A 2D vector.
     * @return A vector perpendicular to the passed one.
     */
    public static Vector2D perpendicular(final Vector2D in_direction)
    {
        return new Vector2D(-in_direction.getY(), in_direction.getX());
    }

    /**
     * Returns the dot product of two vectors.
     * @param lhs The first vector
     * @param rhs The second vector
     * @return The dot product of the two vectors.
     */
    public static float dot(final Vector2D lhs, final Vector2D rhs)
    {
        return (float)((double)(lhs.getX()) * (double)(rhs.getX()) + (double)(lhs.getY()) * (double)(rhs.getY()));
    }

    /**
     * Returns the unsigned angle in degrees between from and to.
     * @param from The vector from which the angle is measured.
     * @param to The vector to which the angle is measured.
     * @return The unsigned angle in degrees between the two vectors.
     */
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

    /**
     * Returns the signed angle in degrees between from and to.
     * @param from The vector from which the angle is measured.
     * @param to The vector to which the angle is measured.
     * @return The signed angle in degrees between the two vectors.
     */
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

    /**
     * Returns the distance between vectors a and b.
     * @param a The first vector.
     * @param b The second vector.
     * @return The distance between the two vectors.
     */
    public static float distance(final Vector2D a, final Vector2D b)
    {
        final var delta_x = b.getX() - a.getX();
        final var delta_y = b.getY() - a.getY();

        return (float)Math.sqrt(delta_x * delta_x + delta_y * delta_y);
    }

    /**
     * Returns a copy of a vector with its magnitude clamped to max_length.
     * @param vector The vector to copy.
     * @param max_length The length to clamp the vector to.
     * @return A copy of the vector with its magnitude clamped to max_length.
     */
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

    /**
     * Returns the square magnitude of a vector.
     * @param a The vector to get the square magnitude of.
     * @return The square magnitude of the passed vector.
     */
    public static float sqrMagnitude(final Vector2D a)
    {
        return (float)((double)(a.getX()) * (double)(a.getX()) + (double)(a.getY()) * (double)(a.getY()));
    }

    /**
     * Returns a vector that is made from the smallest components of two vectors.
     * @param lhs The first vector.
     * @param rhs The second vector.
     * @return A vector that is made from the smallest components of two vectors.
     */
    public static Vector2D min(final Vector2D lhs, final Vector2D rhs)
    {
        return new Vector2D(Math.min(lhs.getX(), rhs.getX()), Math.min(lhs.getY(), rhs.getY()));
    }

    /**
     * Returns a vector that is made from the largest components of two vectors.
     * @param lhs The first vector.
     * @param rhs The second vector.
     * @return A vector that is made from the largest components of two vectors.
     */
    public static Vector2D max(final Vector2D lhs, final Vector2D rhs)
    {
        return new Vector2D(Math.max(lhs.getX(), rhs.getX()), Math.max(lhs.getY(), rhs.getY()));
    }

}
