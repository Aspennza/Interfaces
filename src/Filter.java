/**
 * Creates an interface for filtering Objects based on specific criteria.
 * Establishes a method declaration for accepting or rejecting Objects.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public interface Filter
{
    /**
     * Provides the framework for a method that accepts or rejects Objects based on specific criteria.
     * @param x An Object that will be evaluated based on predefined criteria.
     * @return  A boolean value representing whether the Object met necessary criteria.
     */
    boolean accept(Object x);
}
