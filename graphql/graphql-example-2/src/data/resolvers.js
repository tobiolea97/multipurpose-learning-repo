import { Contacts } from './dbConnectors';

export const resolvers = {
    Query: {
        getContacts: () => {
            return Contacts.find();
        },
        getOneContact: async (root, { id }) => {
            try {
                const contact = await Contacts.findById(id);
                return contact;
            } catch (err) {
                throw new Error('Error saving contact: ' + err.message);
            }
        }
    },
    Mutation: {
        createContact: async (root, { input }) => {
            const newContact = new Contacts({
                firstName: input.firstName,
                lastName: input.lastName,
                email: input.email,
                company: input.company,
            });

            newContact.id = newContact._id;

            try {
                await newContact.save();
                return newContact;
            } catch (err) {
                throw new Error('Error saving contact: ' + err.message);
            }
        },
        updateContact: async (root, { input }) => {
            try {
                const updatedContact = await Contacts.findOneAndUpdate({ _id: input.id}, input, { new: true });
                return updatedContact;
            } catch (err) {
                throw new Error('Error saving contact: ' + err.message);
            }
        }
    }
}
