const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
/* eslint-disable no-unused-vars */
const UserService = require('../../services/UserService');

/**
 * This module sets up and configures passport
 * @param {*} config
 */
module.exports = (config) => {
  passport.use(
    new LocalStrategy(
      {
        passReqToCallback: true,
      },
      async (req, username, password, done) => {
        try {
          const user = await UserService.findByUsername(req.body.username);
          if (!user) {
            req.session.messages.push({
              text: 'Invalid username or password!',
              type: 'danger',
            });
            return done(null, false);
          }

          if (user && !user.verified) {
            req.session.messages.push({
              text: 'Please verify your email address!',
              type: 'danger',
            });
            return done(null, false);
          }
          const isValid = await user.comparePassword(req.body.password);
          if (!isValid) {
            req.session.messages.push({
              text: 'Invalid username or password!',
              type: 'danger',
            });
            return done(null, false);
          }
          return done(null, user);
        } catch (err) {
          return done(err);
        }
      }
    )
  );
  passport.serializeUser((user, done) => {
    done(null, user.id);
  });

  passport.deserializeUser(async (id, done) => {
    try {
      const user = await UserService.findById(id);
      return done(null, user);
    } catch (err) {
      return done(err);
    }
  });
  return passport;
};
