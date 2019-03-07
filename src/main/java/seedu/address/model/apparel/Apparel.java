package seedu.address.model.apparel;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Apparel in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Apparel {

    // Identity fields
    private final Name name;
    private final Color color;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Apparel(Name name, Color color, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, color, email, address, tags);
        this.name = name;
        this.color = color;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Apparel otherApparel) {
        if (otherApparel == this) {
            return true;
        }

        return otherApparel != null
                && otherApparel.getName().equals(getName())
                && (otherApparel.getColor().equals(getColor()) || otherApparel.getEmail().equals(getEmail()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Apparel)) {
            return false;
        }

        Apparel otherApparel = (Apparel) other;
        return otherApparel.getName().equals(getName())
                && otherApparel.getColor().equals(getColor())
                && otherApparel.getEmail().equals(getEmail())
                && otherApparel.getAddress().equals(getAddress())
                && otherApparel.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, color, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Color: ")
                .append(getColor())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
